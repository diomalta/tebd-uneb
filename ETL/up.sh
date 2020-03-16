docker build -f Dockerfile -t etl .
docker-compose up

sleep 20
docker exec -it config-01 bash -c "echo 'rs.initiate({_id: \"mongodioConf\",configsvr: true, members: [{ _id : 0, host : \"config-01\" },{ _id : 1, host : \"config-02\" }]})' | mongo"
docker exec -it config-01 bash -c "echo 'rs.status()' | mongo"
docker exec -it shard-01 bash -c "echo 'rs.initiate({_id : \"mongodio\", members: [{ _id : 0, host : \"shard-01\" },{ _id : 1, host : \"shard-02\" }]})' | mongo"
docker exec -it shard-01 bash -c "echo 'rs.status()' | mongo"
docker exec -it router-01 bash -c "echo 'sh.addShard(\"mongodio/shard-01\")' | mongo"
docker exec -it router-01 bash -c "echo 'sh.status()' | mongo"

