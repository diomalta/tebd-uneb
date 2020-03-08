const routes = require('express').Router();

const ParticipantController = require('./controller/participants');

routes.get('/participants-to-transfer', ParticipantController.genericJsonSchema);

module.exports = routes;