module.exports = function(sequelize, DataTypes) {
  const Participants = sequelize.define('participants', {
    telephone: DataTypes.STRING,
    name: DataTypes.STRING,
    address_id: DataTypes.INTEGER,
    card_id: DataTypes.INTEGER,
    job_id: DataTypes.INTEGER
  },{
    freezeTableName: true,
    tableName: 'participants',
    timestamps: false
  });

  Participants.associate = function(models) {
    Participants.belongsTo(models.cards, { foreignKey: 'card_id', as: 'cards' });
    Participants.belongsTo(models.address, { foreignKey: 'address_id', as: 'address' });
    Participants.belongsTo(models.address, { foreignKey: 'job_id', as: 'addressJob' });
  };

  return Participants;
}
