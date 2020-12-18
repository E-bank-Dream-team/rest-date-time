package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("""
Represents a successful scenario of get current date and time

```
given:
	/api/v1/dateTime endpoint
when:
	make GET request
then:
	we'll get current date and time
```

""")
    request {
        method('GET')
        url( "/api/v1/dateTime" )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        headers {
            contentType(applicationJson())
        }
        body([
            'date-time': $(c('2020-12-12T10:00:00+00:00'), p(regex(iso8601WithOffset())))
        ])
        bodyMatchers {
            jsonPath('date-time', byRegex(iso8601WithOffset()))
        }
    }
}
