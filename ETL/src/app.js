const express = require('express');
const cors = require('cors')

// const ParticipantsService = require('./service/participants');

class AppController {
  constructor () {
    this.express = express();

    this.middlewares();
    this.routes();
    this.actions();
  }

  middlewares () {
    this.express.use(cors());
    this.express.use(express.json());
  }

  routes () {
    this.express.use('/api', require('./router'))
  }

  async actions () {
    // await ParticipantsService.transfersToMongoDB();
  }
}

module.exports = new AppController().express;