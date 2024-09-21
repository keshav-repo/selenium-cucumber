### API

An API, or Application Programming Interface, is a set of rules and protocols that allow software applications to communicate with each other.

### REST API

A RESTful API is an interface that allows different software systems to communicate with each other over HTTP using the principles of REST.

HTTP is like a messenger that helps computers talk to each other on the internet.

### REST principles

REST principles are a set of guidelines for designing web APIs

1. Stateless: Each request should be independent, and the server shouldn't store any state about the client.
2. Client-server: The client (e.g., a web browser) sends requests to the server, which processes them and sends back responses.
3. Resource-based: APIs should treat everything as a resource and use URLs to represent them.
4. Cacheable: Responses can be cached to improve performance.

#### REST vs SOAP

| Feature              | REST (Representational State Transfer) | SOAP (Simple Object Access Protocol) |
| -------------------- | -------------------------------------- | ------------------------------------ |
| **Architecture**     | Stateless, client-server               | Stateful or stateless                |
| **Data format**      | JSON, XML, others                      | XML                                  |
| **Methods**          | HTTP methods                           | SOAP-specific methods                |
| **State management** | Stateless                              | Stateful or stateless                |
| **Caching**          | Supported                              | Less common                          |
| Protocol             | Works over HTTP, HTTPS, SMTP and other | Works over HTTP and HTTPS            |

sample xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<bookstore>
    <book category="Fiction">
        <title lang="en">The Great Gatsby</title>
        <author>F. Scott Fitzgerald</author>
        <year>1925</year>
        <price>10.99</price>
    </book>
    <book category="Science Fiction">
        <title lang="en">Dune</title>
        <author>Frank Herbert</author>
        <year>1965</year>
        <price>15.99</price>
    </book>
    <book category="Programming">
        <title lang="en">Clean Code</title>
        <author>Robert C. Martin</author>
        <year>2008</year>
        <price>29.99</price>
    </book>
</bookstore>
```

### HTTP headers

HTTP headers are additional pieces of information that are sent along with HTTP requests and responses.

Headers:

1. User-Agent: browser, android
2. Authorization: Contains authentication credentials, such as a token or username/password.
3. Content-Type: JSON
4. Cookie: Contains cookies sent by the server to the client.

### Rest api methods

REST (Representational State Transfer) APIs use HTTP methods to represent different types of operations on resources. Different operation can be read, write, update delete.

### PUT vs Patch

PUT is used to replace the entire resource, while PATCH is used to update specific fields.

### HTTP status codes?

1. 200 OK
2. 201 Created
3. 204 No Content: The request was successful, but there is no additional data to send in the response. This code is often used in response to DELETE requests.
4. 400 Bad Request: The server cannot understand the request due to a client error, malformed syntax, or invalid parameters.
5. 401 Unauthorized: The client is not authorized to access the resource.
6. 403 Forbidden:The client does not have permission to access the requested resource, even with valid authentication credentials.

7. 404 Not Found: The server cannot find the requested resource or endpoint.

8. 500 Internal Server Error: The server encountered an unexpected issue.

9. 503 Service Unavailable: The server is temporarily unavailable
10. 502 Bad Gateway: The server received an invalid response from an upstream server
11. 504 Gateway Timeout: The server acting as a gateway or proxy did not receive a timely response from the upstream server.

### Env variable:

Environmental variables in Postman are like placeholders that you can use to store and reuse values across different requests

### advantages and drawbacks of REST api

1. Simplicity
2. Flexibility: REST APIs are flexible and can be used with a variety of programming languages and platform
3. Cacheability: REST APIs can be highly cacheable, improving performance and reducing load on the server.
4. Statelessness: REST APIs are stateless, meaning each request is independent and doesn't rely on previous requests. This makes them easier to cache and distribute.

5. Over-fetching: REST APIs can sometimes fetch more data than is necessary, leading to inefficient use of resources.
6. Security: REST APIs can be vulnerable to security threats such as injection attacks and unauthorized access.
