<!DOCTYPE html>
<html lang="en">

<body>

<h2>CONTAINS</h2>
<ol>
    <li>
        <a href="#Java1">Java</a>
    </li>
    <li>
        <a href="#JDBC1">JDBC</a>
    </li>
    <li>
        <a href="#Serialization1">Serialization</a>
    </li>
    <li>
        <a href="#SpringFramework">Spring Framework</a>
    </li>
    <li>
        <a href="#Hibernate">Hibernate</a>
    </li>
    <li>
        <a href="#EntityLifeCycle">Entity Life Cycle</a>
    </li>
</ol>




<h2>JAVA <a id="Java1"></a></h2>

<h3>JVM parameters</h3>
-Xms - minimum heap
-Xmx - max heap

<h3>JVM GC implementations</h3>
JVM has four types of GC implementations:

<li>Serial Garbage Collector</li>
<li>Parallel Garbage Collector</li>
<li>CMS Garbage Collector</li>
<li>G1 Garbage Collector</li>

<h3>OOP pillars</h3>
<li>Abstraction</li>
Abstraction aims to hide complexity from users and show them only relevant information. 
For example, if you’re driving a car, you don’t need to know about its internal workings.
The same is true of Java classes. You can hide internal implementation details using abstract classes or interfaces. 
On the abstract level, you only need to define the method signatures (name and parameter list) and let each class implement them in their own way.
Of smartphone is a mean of communication and communication might be in diff ways: text messaging, calling, video calls - different forms;

Abstraction in Java:
<li>
<ul>Hides the underlying complexity of data</ul>
<ul>Helps avoid repetitive code</ul>
<ul>Presents only the signature of internal functionality</ul>
<ul>Gives flexibility to programmers to change the implementation of abstract behavior</ul>
<ul>Partial abstraction (0-100%) can be achieved with abstract classes</ul>
<ul>Total abstraction (100%) can be achieved with interfaces</ul>
</li>
<li>Polymorphism</li>
Polymorphism refers to the ability to perform a certain action in different ways. In Java, polymorphism can take two forms: method overloading and method overriding.
Method overloading happens when various methods with the same name are present in a class. When they are called, they are differentiated by the number, order, or types of their parameters. Method overriding occurs when a child class overrides a method of its parent.
Dynamic Polymorphism - Overriding (runtime time)
Static Polymorphism - Overloading (compile time)
Polymorphism in Java:
<li>
<ul>The same method name is used several times</ul>
<ul>Different methods of the same name can be called from an object</ul>
<ul>All Java objects can be considered polymorphic (at the minimum, they are of their own type and instances of the Object class)</ul>
<ul>Static polymorphism in Java is implemented by method overloading</ul>
<ul>Dynamic polymorphism in Java is implemented by method overriding</ul>
</li>

<li>Encapsulation</li>
<ul>private (within class only)</ul>
<ul>default (package private)</ul>
<ul>protected (visible in package or all subclasses)</ul>
<ul>public (visible everywhere)</ul>

<li>Inheritance</li>
Inheritance makes it possible to create a child class that inherits the fields and methods of the parent class
Inheritance in Java:
<li>
<ul>A class (child class) can extend another class (parent class) by inheriting its features</ul>
<ul>Implements the DRY (Don’t Repeat Yourself) programming principle</ul>
<ul>Improves code re-usability</ul>
<ul>Multi-level inheritance is allowed in Java (a child class can have its own child class as well)</ul>
<ul>Multiple inheritances are not allowed in Java (a class can’t extend more than one class)</ul>
</li>

<h3>Composition</h3>
The composition is a design technique in java to implement a has-a relationship.

<h3>Objects methods</h3>
<ul>clone() (return Class object of this class)</ul>
<ul>getObject() (return copy of object)</ul>
<ul>hashcode() (return (int) hashcode. Default implementation return reference)</ul>
<ul>toString() (return String representation of object)</ul>
<ul>final void notify() (wakes up single thread, waiting on object's monitor)</ul>
<ul>final void notifyAll() (wakes up all threads)</ul>
<ul>final void wait() (waits for specified milliseconds until another thread notifies)</ul>
<ul>finalize (is invoked by GB before object is going to be eliminated @Deprecated in Java9)</ul>

<h3>Finalize vs GC</h3>
System.gc() (native method) kindly asks the system to perform a garbage collection, but no guarantee that GC will be
performed.
Object.finalize() can be overridden to specify what to do when object is garbaged collected. Object.finalize() is
deprecated in Java 9.

<h3>Equals vs Hashcode Contracts</h3>
<h5>Equals</h5>
<ul>reflexive: object must be equal itself</ul>
<ul>symmetric: x.equals(y) must be equal y.equals(x)</ul>
<ul>transitive: x.equals(y) and y.equals(z) then x.equals(z) </ul>
<ul>consistent: the value of equals() should change only if a property that is contained in equals() changes (no randomness allowed) </ul>
If two objects are equal according to the equals() method, then calling the hashCode() on each of the two objects must produce the same integer result

<h3>Collections</h3>
<h5>BigO</h5>
O(1): Executes in the same time regardless of the size of the input
O(log(N)): Logarithmic complexity (binary search)
O(n): Executes linearly and proportionally to the size of the input
O(N log N)
O(n²): (Polynomial) Performance is directly proportional to the square of the size of the input (ex: nested iterations,
loops)
O(k^n): e.g. if n=2 then 2^2 = 4 algorithm will run 4 times

<h5>Array BigO</h5>
get(i) -> O(1)
other operations -> O(n)

<h5>ArraysList/CopyOnWriteArrayList(thread safe) </h5>
An ArrayList is an index based data structure backed by an Array
add():O(1), worst case o(n) when new array need to be created
add(index,value):O(n)
get():O(1)
indexOf()/contains(): O(n)

<h5>LinkedList</h5>
It maintains insertion order, every element is node which keeps a reference of the next 
and previous node. Values of LinkedList is distributed in heap.
A LinkedList consumes more memory than an ArrayList because of every node in a LinkedList stores two references, one for
its previous element and one for its next element, whereas ArrayList holds only data and its index.
add(): O(1)
add(index,value):O(n)
get()/remove()/contains():O(n)

<h5>HashMap</h5>
Not sync'ed
Allows null values and only one null key
Iterators are fail fast (throws ConcurrentModificationException in modifying object)
Fast
containsKey()/get/put/remove:O(1) if hashcode and equals are implemented properly, if not then O(n)

If equals and hashcode implemented correctly then:
searching / deleting / adding - o(1)
worst case - O(n) linear
if we break threshold (8) - worst case is O(log(n)) because of RedBlackTree

<h5>HashTable</h5>
Not sync'ed
Does not allow null values and keys
Iterators are fail-safe
Slow(comparing to HashMap)
Legacy, not recommended to use

<h5>TreeMap/ConcurrentSkipListMap</h5>
put()/get()/remove()/containsKey(): O(logN)

<h5>HashSet</h5>
It stores unique elements and permits nulls
It's backed by a HashMap
It doesn't maintain insertion order
It's not thread-safe
add()/remove()/contains(): O(1)

<h5>TreeSet</h5>
It orders values (sorted) in ascending way
It's thread-safe
add()/remove()/contains(): O(logN)

<h3>Java: Pass by Value or By Reference???</h3>

<h3>Immutability???</h3>
<h5>String Class, String Pool</h5>
https://www.journaldev.com/797/what-is-java-string-pool
Using new operator, we force String class to create a new String object in heap space. We can use intern() method to put
it into the pool or refer to another String object from the string pool having the same value.
String pool is also example of Flyweight design pattern.

<h3>Concurrency</h3>
<h5>Concurrency vs Parallelism</h5>
<h5>Thread vs Runnable</h5>
<h5>Happened Before Principles</h5>
<h5>Volatile</h5>

<h2>Data Type</h2>
<ul>AutoBoxing (automatically): int -> Integer</ul>
<ul>AutoUnboxing: Integer -> int</ul>

<h2>Java Low Latency Optimization</h2>
<h3>JVM Optimization</h3>
настройки heap
настройки сборщика мусора
настройки JIT-компилятора
прочие настройки

1) Use primitive against Objects (Wrapper), for instance: int == 32 bit, Integer = 4 byte + reference

<h3>SOLID principles</h3>
<li>Single Responsibility Principle (Принцип единственной ответственности)</li>
<ul>
    <li>Each class supposed to be designed to meet single functionality</li>
</ul>
<li>Open Closed Principle (Принцип открытости/закрытости)</li>
<ul>
    <li>Software components should be open for extension, but not for modification</li>
    <li>программные сущности (классы, модули, функции и т.п.) должны быть открыты для расширения, но закрыты для изменения</li>
</ul>
<ul>
<li>Liskov’s Substitution Principle (Принцип подстановки Барбары Лисков)</li>
    <li>Objects of a superclass should be replaceable with objects of its subclasses without breaking the system</li>
    <li>Его можно описать так: объекты в программе можно заменить их наследниками без изменения свойств программы.
Это означает, что класс, разработанный путем расширения на основании базового класса, должен переопределять его методы так, чтобы не нарушалась функциональность с точки зрения клиента. То есть, если разработчик расширяет ваш класс и использует его в приложении, он не должен изменять ожидаемое поведение переопределенных методов.</li>
</ul>
<li>Interface Segregation Principle (Принцип разделения интерфейса)</li>
<ul>
    <li>No client should be forced to depend on methods that it does not use./li>
</ul>
<li>Dependency Inversion Principle (Принцип инверсии зависимостей)</li>
<ul>
    <li>High-level modules should not depend on low-level modules, both should depend on abstractions. Just be depended on Abstraction no on specific class/li>
    <li>зависимости внутри системы строятся на основе абстракций. Модули верхнего уровня не зависят от модулей нижнего уровня. Абстракции не должны зависеть от деталей. Детали должны зависеть от абстракций.Программное обеспечение нужно разрабатывать так, чтобы различные модули были автономными и соединялись друг с другом с помощью абстракции. </li>
</ul>

<h3>Functional Interfaces</h3>
<p>Functional interface is interface which has only one abstract method + you can mark it by @FunctionalInterface annotation for compiler</p>
<p>All functional interfaces are provided in java.util.function package</p>
<li>Supplier: T get()</li>
<li>Consumer: void accept(T)</li>
<li>BiConsumer: void accept(T,U)</li>
<li>Predicate: boolean test(T)</li>
<li>BiPredicate: boolean test(T,U)</li>
<li>Function: R apply(T,R)</li>
<li>BiFunction: R apply(T,U,R)</li>
<li>UnaryOperator: T apply(T)</li>
<li>BinaryOperator: T apply(T,T)</li>

<h3>Comparable vs Comparator</h3>
Java provides Comparable interface which should be implemented by any custom class if we want to use Arrays or
Collections sorting methods.
The Comparable interface has compareTo(T obj) method which is used by sorting methods, you can check any Wrapper, String
or Date class to confirm this.
We should override this method in such a way that it returns a negative integer, zero, or a positive integer if “this”
object is less than, equal to, or greater than the object passed as an argument.
This is the situation where we need to use Java Comparator interface because Comparable.compareTo(Object o) method
implementation can provide default sorting and we can’t change it dynamically.
Whereas with Comparator, we can define multiple methods with different ways of sorting and then chose the sorting method
based on our requirements.
Comparator interface compare(Object o1, Object o2) method need to be implemented that takes two Object argument, it
should be implemented in such a way that it returns negative int if the first argument is less than the second one and
returns zero if they are equal and positive int if the first argument is greater than the second one.

Comparable interface can be used to provide single way of sorting whereas Comparator interface is used to provide
different ways of sorting.
For using Comparable, Class needs to implement it whereas for using Comparator we don’t need to make any change in the
class.
Comparable interface is in java.lang package whereas Comparator interface is present in java.util package.
We don’t need to make any code changes at client side for using Comparable, Arrays.sort() or Collection.sort() methods
automatically uses the compareTo() method of the class. For Comparator, client needs to provide the Comparator class to
use in compare() method.

<h3>Stream</h3>
<p>Stream interface comes from java.util.stream package</p>

<h3>Algorithms</h3>
<p></p>


<h3>Design Patterns</h3>

<h4>Structural Design Pattern</h4>

<li>Facade pattern</li>
<li>Adapter pattern</li>
<li>Decorator pattern</li>
<li>Flyweight pattern: https://www.journaldev.com/1562/flyweight-design-pattern-java</li>

<h2>JDBC <a id="JDBC1"></a></h2>

<h3>CRUD</h3>
<p>CRUD stands for:</p>
<ul>
    <li>CREATE</li>
    <li>READ</li>
    <li>UPDATE</li>
    <li>DELETE</li>
</ul>

<h2>Serialization <a id="Serialization1"></a></h2>

<ul>
    <li>Serialization: Object to byte array</li>
    <li>Deserialization: Byte array transformation into object</li>
</ul>

<p>
    Field supposed to be serialized to be "private final static"
</p>


<h2>Spring Framework <a id="SpringFramework"></a></h2>
<h3>Scope</h3>
<li>Singleton - by default. Only one object is created before calling getBean().
When calling getBean(), the same object is returned every time</li>
<li>Prototype. New object is created every time when calling getBean().
For prototype beans Spring does not call destroy method</li>
<li>Request</li>
<li>Session</li>
<li>Global-Session.</li>

<h3>Bean's methods</h3>
<p>LifeCycle of Bean:</p>
<li>Run Spring application</li>
<li>Spring container is launched</li>
<li>Bean is created</li>
<li>Dependency Injection injected into Bean</li>
<li>Init-Method is called (e.g. resource initialization, connection to DB etc)</li>
<li>Bean is ready for usage</li>
<li>Destroy method is calling (resources release, closure IO etc)</li>
<li>Spring application is closed</li>

Init Method - initialization of the bean
Destroy Method - is called when bean is destroyed i.e. resources are release etc
Factory Method - using factory to create beans

<h3>Spring MVC</h3>
<p>Spring MVC allows to create web application with Java and bring Model - View - Controller design pattern:</p>
<lo>
<li>Model - how we deal with data</li>
<li>View - how our data is represented (e.g. HTML pages)</li>
<li>Controller - how we handle our requests (e.g. HTTP request)</li>
</lo>

<h4>DispatcherServlet</h4>
<p>DispatcherServlet is entry point of MVC application. It is implemented by Spring Framework.
DispatcherServlet handles an incoming HttpRequest, delegates the request, and processes that request according to the configured HandlerAdapter interfaces that have been implemented within the Spring application along with accompanying annotations specifying handlers, controller endpoints, and response objects.
Please, see: https://www.baeldung.com/spring-mvc-tutorial
</p>
HTTP request flow:
<lo>
<li>Client send HTTP request to HTTP server (e.g. TomCat default)</li>
<li>Server receives HTTP and pass it to MVC application</li>
<li>Request is translated to DispatcherServlet</li>
<li>DispatcherServlet routes a request to proper Controller</li>
<lo>

<h4>Controller</h4>
<lo>
<li>@Controller is child of @Component so @ComponentScan works with @Controller in the similar way as it does with @Component</li>
<li>Mapping ties up controller's method with an address</li>
<li>Spring 4.0 introduced the @RestController annotation in order to simplify the creation of RESTful web services. It's a convenient annotation that combines @Controller and @ResponseBody, which eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation</li>
<li>There are five type of mappings:@GetMapping,@PostMapping,@PutMapping,@DeleteMapping,@PatchMapping</li>
</lo>

<h5>GET Request</h5>
<p>Parameters from GET request might be given by two ways:</p>
<lo>
<li>HTTPServletRequest in method signature of controller</li>
<li>@RequestMapping annotation</li>
</lo>

<h2>Hibernate <a id="Hibernate"></a></h2>

<h3>Entity Life Cycle <a id="EntityLifeCycle"></a></h3>
<p> Java objects state in Hibernate:</p>
<lo>
    <li>Transient: Object is not related to Hibernate, this object is not tracked by Hibernate, no sql code generate for this java object</li>
    <li>Persistent: When we call %session.save(entity)% (or extract java object from database) java object moves to Persistent (Managed) state (in Persistence context) and Hibernate executes sql code</li>
    <li>Detached: Java object escapes Persistence context and is no longer being tracked by Hibernate</li>
    <li>Removed: Object is marked as 'deleted' - i.e. when we call %session.remove(entity)%</li>
</lo>


<h2>TESTING</h2>

<h3>TDD - test driven development</h3>
<li>We have a contract by which we see method signature its parameters.</li>
<li>We start write unit test (scenarios) to test contract. Then run tests and they failed. It is expected since there is no implementation</li>
<li>We add implementation and re-run test. Some of them pass and you developed test taking into account contract not method implementation</li>

<h3>Test Design Techniques</h3>
<li>Эквивалентное разделение (Equivalence Partitioning).Как пример, у вас есть диапазон допустимых значений от 1 до 10, 
вы должны выбрать одно верное значение внутри интервала, скажем, 5, и одно неверное значение вне интервала - 0. </li>
<li>Boundary Values (Граничные значения). Если взять пример выше, в качестве значений для позитивного тестирования выберем минимальную и максимальную границы (1 и 10), 
и значения больше и меньше границ (0 и 11)</li>
<li>Reason-Cause technique</li>
<li>Error Guessing (risk test base).Это когда тест аналитик использует свои знания системы 
и способность к интерпретации спецификации на предмет того, чтобы "предугадать" при каких входных условиях система может выдать ошибку</li>
<li>PairWise</li>
<li>Comprehensible Testing</li>

<h2>HTTP / REST  <a id="Rest"></a></h2>
HTTP - HyperText protocol (Application Layer)
REST - Representational state transfer. Web API obeys Rest Restrictions is RESTFul API:
<li>Stateless</li>
<li>Client/Server (Separation Concerns)</li>
<li>Cacheability</li>

<h3>TCP vs UDP </h3>

<h3>HTTP and its methods</h3>
<li>GET - get resources (idempotent i.e. change nothing on server). GET request's body is always empty</li>
<li>POST - create new resource (all request params are in request's body). Content-Type might be JSON, XML</li>
<li>PUT - сheck if resource exists if yes - update, no - create new</li>
<li>DELETE - delete resource</li>
<li>PATCH - update resource</li>

<h3>HTTP ERROR</h3>
<li>200-successful responses</li>
<li>300-redirection responses (e.g. 301 - moved permanently</li>
<li>400-client errors (401 - Bad Request, 403 - Forbidden, 404 -  No Authorized)</li>
<li>500-server errors (500 Internal Server Error), 503 - Service Unavailable</li>

<h2>Java Cache Friendly</h2>
Article : https://algodma.wordpress.com/2021/05/06/%d1%87%d1%82%d0%be-%d0%bd%d0%b0%d0%b4%d0%be-%d0%b7%d0%bd%d0%b0%d1%82%d1%8c-%d0%bf%d1%80%d0%be%d0%b3%d1%80%d0%b0%d0%bc%d0%bc%d0%b8%d1%81%d1%82%d1%83-%d0%be%d0%b1-%d1%83%d1%81%d1%82%d1%80%d0%be%d0%b9/
To get cache-line size (coherency_line_size in bytes): /sys/devices/system/cpu/cpu0/cache/

<h2>POSTGRES</h2>
<p>C:\Dev\JS\Projects\test\server>postgres --version</p>
postgres (PostgreSQL) 14.4

<h3>Connection</h3>
<p>In CMD:</p>
<p>AdminTool: pgAdmin4 opens Admin Tool</p>
<p>Authorize: psql -U postgres</p>
<p>Database connection:</p>
<p>postgres=# \c coffeeshop</p>
<p>You are now connected to database "coffeeshop" as user "postgres". </p>

<h2>LINUX</h2>

<h3>Working with Files</h3>
<p>
To create file in Linux you can run the following command set:

<p>cat<<EOF > /var/tmp/t.log</p>

<p>Less:
SHIFT+G -> move cursor to the end of the file
gg -> move cursor at the file's beginning
:<Number of row> -> move to N row (e.g. ':10')

</p>
GREP:
1) find 'sed' word:
grep -R '\<sed\>' /usr/share
2) find matching (starting) 'r' and 'o'
grep -E '^r?0' /etc/passwd
<p>

</p>
SED:
1) replace log's output but not changing file and display changes:
sed -e 's/string/stringX' test.log #every 'string' will be replaced with 'stringX' in log's output
2) Delete a row from the log
sed -e '3d' test.log # third row will be deleted 
<p>

<h3>Network settings</h3>
</br>
<p>network params -> /etc/network/interfaces</p>
<p>daemon NetworkManager help to streamline network set up e.g. ethernet, wi-fi: systemctl restart NetworkManager</p>
<p>systemd-networkd -> system daemon for management of network setting</p>
<p>command 'hostname' is a result of 'less' /proc/sys/kernel/hostname </p>
<p>'ip a' -> output of address configuration</p>
<p> 'ip addr' || 'ifconfig' allows you to change network params in RAM</p>
<p> 'nmtui' -> utility for NetworkManager(GUI)</p>

<h3>Core</h3>
<p>To find out what modules (ls /lib/modules/`uname -r` are loaded in RAM -> 'lsmod'</p>

<h3>Devices</h3>
<p>Get latest message from kernel from ring buffer, run `dmesg`</p>


</body>
</html>