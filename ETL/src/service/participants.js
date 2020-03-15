const { participants: participantsMariaDB, cards, address } = require('../model/mariaDB');
const { Participants: participantsMongoDB } = require('../model/mongoDB');

class ParticipantsService {
  constructor () {
    this.mariaDb = participantsMariaDB;
    this.mongoDb = participantsMongoDB;
  }

  async genericJsonSchema() {
    const participants = await this.mariaDb.findAll({
      include: [
        { model: cards, as: 'cards' }, 
        { model: address, as: 'address' },
        { model: address, as: 'addressJob' }
      ]
    })

    if (!participants) {
      return [];
    }
    
    return {
      result: participants.map(participant => ({
        name: participant.name,
        telephone: participant.telephone,
        address: participant.address ? {
          address: participant.address.address,
          cep: participant.address.cep
        } : {},
        jobs: participant.jobs ? {
          address: participant.jobs.address,
          cep: participant.jobs.cep
        } : {},
        cards: participant.cards && participant.cards instanceof Array ? 
          participant.cards.dataValues.map(card => ({
            number: card.number,
            flag: card.flag,
            ccv: card.ccv,
            due: card.due,
          })): participant.cards ? [
            {
              number: participant.cards.dataValues.number,
              flag: participant.cards.dataValues.flag,
              ccv: participant.cards.dataValues.ccv,
              due: participant.cards.dataValues.due,
            }
          ] : [],
      }))
    };
  }

  async upsertMongoDB(participants) {
    let count = 0;
    for (const participant of participants) {
      const createdParticipant = await this.mongoDb.create({ ...participant });

      if (createdParticipant) {
        console.warn(`Participante ${createdParticipant.name} foi adicionado com sucesso`);
        count++;
      }
    }

    if (count !== participants.length) {
      throw new Error(`A quantidade registrada (${count}) não condiz com que solicitado para ser registrado (${participants.length})`);
    }

    return true;
  }

  async transfersToMongoDB() {
    const participants = await this.genericJsonSchema();
    await this.upsertMongoDB(participants);
  }
}

module.exports = new ParticipantsService()