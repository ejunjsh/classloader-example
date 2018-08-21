# classloader-example

this is experiment to know how classloader run

# begin

    sudo docker-compose run app
    
then will return a bash ,you run below command

    sh app.sh
    
then the output is 

    # ignore maven build log
    =====app1=======
    AppClassLoader load applib1
    applib1:
    CommonClassLoader load Calculator
    3
    =====app2=======
    AppClassLoader load applib2
    applib2:
    CommonClassLoader load Calculator
    4
    
i define two classloader `AppClassLoader` and its parent classloader`CommonClassLoader`, 

the first classloader loads class in path you specify.

the second classloader is on the common path `/opt/cl/common`,so i put the `Calculator` class there

so i run the two app which are `app1` and `app2`

you will see the output they load `calcultor` from `CommonClassLoader` 

and their `applib` class is loaded by their own `AppClassLoader`

# conclusion

this example is similar with tomcat or some web container. 

they use `AppClassLoader` to load the different application

but share common library with `CommonClassLoader`.