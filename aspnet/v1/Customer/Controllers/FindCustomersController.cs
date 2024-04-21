using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace v1.Customer.Controllers;

[Route("api/v1/customers")]
[ApiController]
public class FindCustomersController(AppDbContext context) : ControllerBase
{
    private readonly AppDbContext _context = context;

    [HttpGet]
    public ActionResult<List<CustomerEntity>> FindAll()
    {
        return Ok(_context.Customers.ToList());
    }
}
