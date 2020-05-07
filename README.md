# sno-seed
The "father of all" dependencies used on the mod/plugin creation on the Sword Nation Online.

## How to use the dependency
### Maven Dependency:

  Repository:

```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

  Dependency:
```
	<dependency>
	    <groupId>com.github.SNO-1-12-2</groupId>
	    <artifactId>sno-seed</artifactId>
	    <version>1.2.0</version>
	</dependency>
```

### Gradle dependency:

  Repository:

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

  Dependency:
  
```
	dependencies {
	        implementation 'com.github.SNO-1-12-2:sno-seed:1.0.0'
	}
```
  
