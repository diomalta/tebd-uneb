const express = require('express');
const CardsService = require('./service/cards');

class AppController {
  constructor () {
    this.express = express()

    this.middlewares()
    this.actions()
  }

  middlewares () {
    this.express.use(express.json())
  }

  async actions () {
    console.warn(await CardsService.getAll());
  }
}

module.exports = new AppController().express