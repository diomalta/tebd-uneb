module.exports = {
  up: (queryInterface, Sequelize) => {
    const SyncronizationTable = queryInterface.createTable('syncronization', {
      id: {
        allowNull: false,
        autoIncrement: true,
        primaryKey: true,
        type: Sequelize.INTEGER
      },
      device_id: {
        allowNull: true,
        type: Sequelize.STRING
      },
      count: {
        allowNull: true,
        type: Sequelize.INTEGER,
        default: 0
      },
      done: {
        allowNull: true,
        type: Sequelize.BOOLEAN
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

    return SyncronizationTable;
  },

  down: queryInterface => queryInterface.dropTable('syncronization'),
};