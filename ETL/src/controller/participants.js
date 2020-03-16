const ParticipantsService = require('../service/participants');
const logger = require('../service/logs');

class ParticipantsController {
  async genericJsonSchema (req, res, next) {
    try {
      const {result} = await ParticipantsService.genericJsonSchema();
      logger.info(`Gerado total de ${result.length} schema de participantes para sincronização`);
      return res.status(200).json(result);
    } catch (err) {
      logger.error(`Algo deu errado: ${err}`);
      return next(err)
    }
  }
}

module.exports = new ParticipantsController()