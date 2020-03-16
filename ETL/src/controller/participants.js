const ParticipantsService = require('../service/participants');
const logger = require('../service/logs');

class ParticipantsController {
  async genericJsonSchema (req, res, next) {
    try {
      const response = await ParticipantsService.genericJsonSchema();
      logger.info(`Gerado total de ${response.length} schema de participantes para sincronização`);
      return res.status(200).json(response);
    } catch (err) {
      logger.error(`Algo deu errado: ${err}`);
      return next(err)
    }
  }
}

module.exports = new ParticipantsController()