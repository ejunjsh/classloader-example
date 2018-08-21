# classloader-example

this is experiment to know how classloader run

# begin

    sudo docker-compose run app
    
then will return a bash ,you run below command

    sh container.sh
    
then the output is 

    # ignore maven build log
    start up the app 1:
    AppClassLoader load applib1
    applib1:
    CommonClassLoader load Calculator
    3
    start up the app 2:
    AppClassLoader load applib2
    applib2:
    4
    
i define two classloader `AppClassLoader` and its parent classloader`CommonClassLoader`, 

the first classloader loads classes in path you specify.

the second classloader loads classes from common path `/opt/cl/common`,so i put the `Calculator` class there

so i execute `container` that run two app `app1` and `app2`

you will see the output they load `calcultor` from `CommonClassLoader` only one time

and use  `AppClassLoader` to load their own  `applib`

for detail you can see the code.

# conclusion

this example is similar with tomcat or some other web container. 

they use `AppClassLoader` to load the different application

but share common library with `CommonClassLoader`.