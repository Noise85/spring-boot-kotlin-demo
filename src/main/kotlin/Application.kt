package ch.iceage.demo

import jakarta.servlet.ServletContext
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.WebApplicationInitializer

@SpringBootApplication
class Application : WebApplicationInitializer {

    override fun onStartup(servletContext: ServletContext) {
        SpringApplication.run(Application::class.java)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }

}