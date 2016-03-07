# regurgitator-extensions-json

regurgitator is a modular, light-weight, extendable java-based processing framework designed to 'regurgitate' canned or clever responses to incoming requests; useful for mocking or prototyping services.

start your reading here: [regurgitator-all](http://github.com/talmeym/regurgitator-all#regurgitator)

read more about regurgitator in json here: [regurgitator-core-json](http://github.com/talmeym/regurgitator-core-json#json-configuration-of-regurgitator)

## extension steps in json

### json-parameter

a json-parameter creates a parameter, extracting it's value from within a json document, using json-path:

```json
{
    "kind": "json-parameter",
    "name": "book-name",
    "source": "book-catalogue",
    "json-path": "$.catalogue.book.name"
}
```

### xml-parameter

an xml-parameter creates a parameter, extracting it's value from within an xml document, using xpath:

```json
{
    "kind": "xml-parameter",
    "name": "book-name",
    "source": "book-catalogue",
    "xpath": "/bk:catalogue/bk:book/bk:name",
    "namespaces": {
        "bk": "http://books.com"
    }
}
```

## extension constructs in xml

### freemarker-builder 

a freemarker-builder agregating parameter values together using a freemarker template.

```json
{
    "kind": "freemarker-builder",
    "source": "template-param"
}

{
    "kind": "freemarker-builder",
    "file": "classpath:/template.ftl"
}

{
    "kind": "freemarker-builder",
    "value": "This is a ${descriptive} day"
}
```

a freemarker-builder can use the same value source properties as other steps, such as ``create-parameter``, getting its template text from a source parameter, a file or an explicit value.

a freemarker-builder builds from just the ``parameters`` context by default. if the ``all-contexts`` property is true, all context data is made available to the builder, with dashes replaced by underscores in context names, and the colon separating context and parameter names replaced with a period, eg. ``request-metadata:method`` becomes ``request_metadata.method`` when referenced in the template.

```json
{
    "kind": "freemarker-builder",
    "all-contexts": "true",
    "value": "{ \"response\": \"${response_payload.text}\", \"status-code\": ${response-metadata.status_code}, \"content-type\": \"${response-metadata.content_type}\" }"
}

```

### velocity-builder

a freemarker-builder agregating parameter values together using a freemarker template.

```json
{
    "kind": "velocity-builder",
    "source": "template-param"
}

{
    "kind": "velocity-builder",
    "file": "classpath:/template.ftl"
}

{
    "kind": "velocity-builder",
    "value": "This is a ${descriptive} day"
}
```

a velocity-builder can use the same value source properties as other steps, such as ``create-parameter``, getting its template text from a source parameter, a file or an explicit value.

a velocity-builder builds from just the ``parameters`` context by default. if the ``all-contexts`` property is true, all context data is made available to the builder, with dashes replaced by underscores in context names, and the colon separating context and parameter names replaced with a period, eg. ``request-metadata:method`` becomes ``request_metadata.method`` when referenced in the template.

```json
{
    "kind": "velocity-builder",
    "all-contexts": "true",
    "value": "{ \"response\": \"${response_payload.text}\", \"status-code\": ${response-metadata.status_code}, \"content-type\": \"${response-metadata.content_type}\" }"
}

```

### json-path-processor

a json-path-processor processes a parameter value, extracting a value from it using json path.

```json
{
    "kind": "create-parameter",
    "name": "book-name",
    "source": "book-catalogue",
    "processor": {
        "kind": "json-path-processor",
        "json-path": "$.catalogue.book.name"
    }
}
```

### xpath-processor

an xpath-processor processes a parameter value, extracting a value from it using xpath.

```json
{
    "kind": "create-parameter",
    "name": "book-name",
    "source": "book-catalogue",
    "processor": {
        "kind": "xpath-processor",
        "xpath": "/cat:atalogue/bk:book/@name",
        "namespaces": "cat=http://catalogues.com,bk=http://books.com"
    }
}
```

namespaces for an xpath-processor can also be declared as a object property of the processor:

```json
{
    "kind": "create-parameter",
    "name": "book-name",
    "source": "book-catalogue",
    "processor": {
        "kind": "xpath-processor",
        "xpath": "/cat:atalogue/bk:book/@name",
        "namespaces": {
            "cat": "http://catalogues.com",
            "bk": "http://books.com"
        }
    }
}
```

### freemarker-processor

### velocity-processor

### xml-schema-validator
