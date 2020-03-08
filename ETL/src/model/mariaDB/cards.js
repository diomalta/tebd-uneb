module.exports = function(sequelize, DataTypes) {
  const Cards =  sequelize.define('cards', {
    number: DataTypes.STRING,
    flag: DataTypes.STRING,
    ccv: DataTypes.STRING,
    due: DataTypes.DATE,
  },{
    freezeTableName: true,
    tableName: 'cards',
    timestamps: false
  });

  Cards.associate = function(models) {
    Cards.hasMany(models.participants, { foreignKey: 'card_id' });
  };

  return Cards;
}
