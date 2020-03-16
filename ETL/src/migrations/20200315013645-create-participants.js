module.exports = {
  up: (queryInterface, Sequelize) => {
    const ParticipantsTable = queryInterface.createTable('participants', {
      id: {
        allowNull: false,
        autoIncrement: true,
        primaryKey: true,
        type: Sequelize.INTEGER
      },
      telephone: {
        allowNull: true,
        type: Sequelize.STRING
      },
      name: {
        allowNull: true,
        type: Sequelize.STRING
      },
      email: {
        allowNull: true,
        type: Sequelize.STRING
      },
      address_id: {
        type: Sequelize.INTEGER,
        references: { model: 'address', key: 'id' },
      },
      job_id: {
        type: Sequelize.INTEGER,
        references: { model: 'address', key: 'id' },
      },
      card_id: {
        type: Sequelize.INTEGER,
        references: { model: 'cards', key: 'id' },
      },
      createdAt: {
        allowNull: false,
        type: Sequelize.DATE,
        defaultValue: new Date(),
      },
      updatedAt: {
        allowNull: false,
        type: Sequelize.DATE,
        defaultValue: new Date(),
      },
    });

    return ParticipantsTable;
  },

  down: queryInterface => queryInterface.dropTable('participants'),
};