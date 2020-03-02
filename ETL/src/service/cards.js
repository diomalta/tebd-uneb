const { cards } = require('../model');

class CardsService {
  constructor () {
    this.cards = cards;
  }

  async getAll() {
    const cards = await this.cards.findAll()

    if (!cards) {
      return "WTF!"
    }

    return cards;
  }
}

module.exports = new CardsService()