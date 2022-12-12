cd /d D:/
cd D:\redis\Redis-x64-5.0.14.1
start redis-server.exe
cd D:\rocketmq\rocketmq-all-5.0.0-bin-release\bin
start mqnamesrv.cmd
start mqbroker.cmd -n localhost:9876 -c ../conf/broker.conf autoCreateTopicEnable=true
