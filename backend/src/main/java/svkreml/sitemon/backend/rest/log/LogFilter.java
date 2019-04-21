package svkreml.sitemon.backend.rest.log;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Provider
@Slf4j(topic = "security.rest")
public class LogFilter implements ContainerRequestFilter, ContainerResponseFilter {


    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if (containerRequestContext.getSecurityContext().getUserPrincipal() != null) {
            log.info("Обращение к '{}', логин: '{}', тело запроса \n------------\n{}\n------------\n",
                    containerRequestContext.getUriInfo().getAbsolutePath(),
                    containerRequestContext.getSecurityContext().getUserPrincipal().getName(),
                    IOUtils.toString(containerRequestContext.getEntityStream(), StandardCharsets.UTF_8)
            );
        } else {
            log.info("Обращение к '{}', анонимный доступ, тело запроса \n------------\n{}\n------------\n",
                    containerRequestContext.getUriInfo().getAbsolutePath(),
                    IOUtils.toString(containerRequestContext.getEntityStream(), StandardCharsets.UTF_8)
            );
        }
    }


    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {

        if (containerRequestContext.getSecurityContext().getUserPrincipal() != null) {
            log.info("Ответ от '{}', логин: '{}', результат запроса: код='{}'",
                    containerRequestContext.getUriInfo().getAbsolutePath(),
                    containerRequestContext.getSecurityContext().getUserPrincipal().getName(),
                    containerResponseContext.getStatus());
        } else {
            log.info("Ответ от '{}', анонимный доступ, результат запроса: код='{}', тело ответа \n------------\n{}\n------------\n",
                    containerRequestContext.getUriInfo().getAbsolutePath(),
                    containerResponseContext.getStatus(),
                    (containerResponseContext.getEntity().toString())
            );
        }
    }
/*
    @Override
    public Response toResponse(Exception ex) {
    }*/
}
