package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "getting board should return greetings with a bonus joke"

    request {
        url "/board"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                greetings: [
                        [
                            id: "1",
                            language: "Ukrainian",
                            message: "Привіт"
                        ],
                        [
                            id: "2",
                            language: "English",
                            message: "Hello"
                        ]
                ],
                bonusJoke: "A bonus Joke"
        )
    }
}
