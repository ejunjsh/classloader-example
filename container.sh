mvn install

rm -rf /opt/cl

mkdir -p /opt/cl/common
mkdir -p /opt/cl/applib2
mkdir -p /opt/cl/applib1

cp target/classes/Calculator.class /opt/cl/common
cp target/classes/applib2.class /opt/cl/applib2
cp target/classes/applib1.class /opt/cl/applib1

cp target/classes/container.class .
cp target/classes/CommonClassloader.class .
cp target/classes/AppClassloader.class .


java container
