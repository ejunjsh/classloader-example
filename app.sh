mvn install

rm -rf /opt/cl

mkdir -p /opt/cl/common
mkdir -p /opt/cl/applib2
mkdir -p /opt/cl/applib1

cp target/classes/Calculator.class /opt/cl/common
cp target/classes/applib2.class /opt/cl/applib2
cp target/classes/applib1.class /opt/cl/applib1

cp target/classes/app1.class .
cp target/classes/app2.class .
cp target/classes/CommonClassloader.class .
cp target/classes/AppClassloader.class .

echo "=====app1======="

java app1

echo "=====app2======="

java app2