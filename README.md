# ruc-queue-sdk


# Intalacion de la libreria

###Agregar al proyecto:

	<parent>
		<groupId>com.yell</groupId>
		<artifactId>root</artifactId>
		<version>1.0.0</version>
	</parent>
	
### Para instalarlo localmente bajar: 

	http://subversion.aws.yellargentina.com/svn/amarillas/SCM/ParentPOM/trun/root/pom.xml

### ejecutar: 

	mvn clean install
	
### agregar la dependencia:
	
	<dependency>
		<groupId>com.guru.ruc.queue</groupId>
		<artifactId>queue-service-sdk</artifactId>
		<version>2.0</version>
	</dependency>

## Info queue

### INPUT
	
**NAME:** ruc-input-1

**ID:** 8c6245ad-9639-4fe8-83df-39327edf823d
	
#### ==== consumers input queue =====

### (1)
	
**NAME:** g-69ef276e-a86a-47ae-bc98-ae9c7162dd2d

**ID:** advertisement-orquestators

### OUTPUT

**NAME:** ruc-output-1

**ID:** ab5ee216-2394-451b-a051-501aeb3f4d2c

#### ==== consumers output queue =====

### (1)

**ID:** g-68a542da-d6dd-473c-8c07-70c5e581d3f

**NAME:** advertisement-edithor-adapters
		
### (2)

**ID:** g-0deebf30-cdd7-4bfd-a5e7-52fef764c497

**NAME:** advertisement-solr-adapters
		
### (3)

**ID:** g-68a542da-d6dd-473c-8c07-70c5e581d3f

**NAME:** advertisement-csapi-adapters 

