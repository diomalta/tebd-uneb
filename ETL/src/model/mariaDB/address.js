module.exports = function(sequelize, DataTypes) {
  const Address = sequelize.define('address', {
    address: DataTypes.TEXT,
    cep: DataTypes.STRING
  },{
    freezeTableName: true,
    tableName: 'address',
    timestamps: false
  });

  Address.associate = function(models) {
    Address.hasOne(models.participants, { foreignKey: 'address_id' });
    Address.hasOne(models.participants, { foreignKey: 'job_id' });
  };

  return Address;
}
