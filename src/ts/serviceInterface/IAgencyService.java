package ts.serviceInterface;

import ts.model.Agency;
import ts.model.Book;
import ts.model.History;
import ts.model.Passenger;
import ts.serviceException.PassengerNotExistException;
import ts.serviceException.PhoneWrongException;
import ts.serviceException.RegisterException;
import ts.serviceException.TicketPayException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


@Path("/Agency")
public interface IAgencyService {
    //查询单个乘客
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/searchPassenger/{agencyID}/{passenger}")
    Response searchPassenger(@PathParam("agencyID") int agencyID, @PathParam("passenger") int passenger) throws PassengerNotExistException;
    //查询旅行社的乘客
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/searchPassenger/{agencyID}")
    List<Passenger> searchPassenger(@PathParam("agencyID") int agencyID);
    //查询乘客
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/searchPassenger/{agencyID}/{function}/{parameter}")
    List<Passenger> searchPassenger(@PathParam("agencyID") int agencyID, @PathParam("function") String function, @PathParam("parameter") String parameter) throws PassengerNotExistException;
    //修改乘客信息
    @POST
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/modifyPassenger/{agencyId}")
    Response modifyPassenger(@PathParam("agencyId") int agencyId, Passenger passenger);
    //增加乘客信息
    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/addPassenger/{agencyId}")
    Response addPassenger(@PathParam("agencyId") int agencyId, Passenger passenger);
    //删除乘客信息
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Path("/deletePassenger/{agencyId}/{id}")
    Response deletePassenger(@PathParam("agencyId") int agencyId, @PathParam("id") int id);
    //旅行社登录
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/doLogin/{phone}/{pwd}")
    Response AgencyLogin(@PathParam("phone") String phone,@PathParam("pwd") String pwd);
    //旅行社注册
    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/AgencyRegister")
    Agency AgencyRegister(Agency agency) throws RegisterException, PhoneWrongException;
    //旅行社信息修改
    @POST
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/modifyAgency")
    Response modifyAgency(Agency agency) throws PhoneWrongException;
    //预订车票
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/bookingTicket/{agencyId}/{historyId}/{passengerId}/{type}")
    Response BookingTicket(@PathParam("agencyId") int agencyId, @PathParam("historyId") int historyId, @PathParam("passengerId") int passengerId, @PathParam("type") int type);
    //取消预约
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/cancelBook/{agencyId}/{id}")
    Response cancelBook(@PathParam("agencyId") int agencyId, @PathParam("id") int id);
    //付款
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/payTicket/{agencyId}/{id}")
    Response payTicket(@PathParam("agencyId") int agencyId, @PathParam("id") int id) throws TicketPayException;

    //打印机票
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/printTicket/{id}/{IDCard}")
    Response printTicket(@PathParam("id") int id, @PathParam("IDCard") String IDCard);

    //通过电话号码查询订单
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/queryBookByPhone/{phone}")
    List<Book> queryBookByPhone(@PathParam("phone") String phone);

    //通过旅行社ID，订单状态查询
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/queryBookByAID/{id}/{status}")
    List<Book> queryBookByAID(@PathParam("id") int agencyID, @PathParam("status") int status);

    //通过航班ID和起止日期查询
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/queryBookByFID/{id}/{start}/{end}")
    List<Book> queryBookByFID(@PathParam("id") String flightID, @PathParam("start") int start, @PathParam("end") int end);
   // 通过历史表ID查询
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/queryBookByHID/{id}")
    List<Book> queryBookByHID(@PathParam("id") int historyID);
    //验证电话号码是否存在
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/checkPhone/{phone}")
    Response checkPhone(@PathParam("phone") String phone);
    //机票查询
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/queryTicket/{start}/{end}/{date}")
    List<History> queryBook(@PathParam("start")String startAirport, @PathParam("end")String endAirport, @PathParam("date")String date) throws ParseException;
    //修改密码
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/modifyPwd/{phone}/{pwd1}/{pwd2}")
    Response modifyPwd(@PathParam("phone")String phone,@PathParam("pwd1")String pwd1,@PathParam("pwd2")String pwd2);
}
