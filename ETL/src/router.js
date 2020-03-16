const routes = require('express').Router();

const ParticipantController = require('./controller/participants');

routes.get('/participants-to-transfer', ParticipantController.genericJsonSchema);

routes.get('/check-health', (req, res, next) => {
  console.log("I'm alive");
  return res.status(200).json({ message: "I'm alive" });
});

module.exports = routes;