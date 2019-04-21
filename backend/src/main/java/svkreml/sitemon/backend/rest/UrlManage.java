package svkreml.sitemon.backend.rest;


import svkreml.sitemon.share.dto.UrlDto;
import svkreml.sitemon.share.dto.UrlFilter;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;


@Stateful
@LocalBean
@Path("/UrlManage")
@Produces("application/json")
@Consumes("application/json")
public class UrlManage {


    @POST
    @Path("/save/{id}")
    public UrlDto save(@PathParam("id") Integer id, UrlDto urlDto) {
        return urlDto;
    }

    @POST
    @Path("/delete/{id}")
    public Boolean delete(@PathParam("id") Integer id) {
        return true;
    }

    @POST
    @Path("/list")
    public List list(UrlFilter filter) {
        List<UrlDto> urlDtos = new ArrayList<>();
        urlDtos.add(UrlDto.getMock());
        return urlDtos;
    }


    @POST
    @Path("/add")
    public UrlDto mult(UrlDto urlDto) {
        return urlDto;
    }
}
