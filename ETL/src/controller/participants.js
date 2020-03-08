const ParticipantsService = require('../service/participants');

class ParticipantsController {
  async genericJsonSchema (req, res, next) {
    try {
      const response = await ParticipantsService.genericJsonSchema();

      return res.status(200).json(response);
    } catch (err) {
      return next(err)
    }
  }
}

module.exports = new ParticipantsController()