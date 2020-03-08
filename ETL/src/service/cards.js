const { cards } = require('../model/mariaDB');

class CardsService {
  constructor () {
    this.cards = cards;
  }

  async getAll() {
    const cards = await this.cards.findAll()

    if (!cards) {
      return [];
    }

    return cards;
  }
}

module.exports = new CardsService()