const mongoose = require('mongoose');

const Participants = new mongoose.Schema(
  {
    telephone: String,
    name: String,
    address: {},
    cards: [],
    jobs: {},
    role: {
      type: String,
      default: 'participants',
    },
  },
  { timestamps: true },
);
module.exports = mongoose.model('Participants', Participants);