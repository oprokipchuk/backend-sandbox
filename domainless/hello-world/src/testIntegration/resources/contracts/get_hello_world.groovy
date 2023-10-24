package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return hello world text"

    request {
        url "/"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType textPlain()
        }
        body ("Hello World!")
    }
}
