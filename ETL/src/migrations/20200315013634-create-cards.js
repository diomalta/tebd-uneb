module.exports = {
  up: (queryInterface, Sequelize) => {
    const CardsTable = queryInterface.createTable('cards', {
      id: {
        allowNull: false,
        autoIncrement: true,
        primaryKey: true,
        type: Sequelize.INTEGER
      },
      number: {
        allowNull: false,
        type: Sequelize.STRING
      },
      flag: {
        allowNull: false,
        type: Sequelize.STRING
      },
      ccv: {
        allowNull: false,
        type: Sequelize.STRING
      },
      due: {
        allowNull: false,
        type: Sequelize.DATE
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

    return CardsTable;
  },

  down: queryInterface => queryInterface.dropTable('cards'),
};
