using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;
using v1.Customer.DTOs;
using v1.Customer.Services;

namespace v1.Customer.Controllers;

[Route("api/v1/customer")]
[ApiController]
public class UpdateCustomerController(AppDbContext context, FindCustomerBySsn findCustomer) : ControllerBase
{
    private readonly AppDbContext _context = context;
    private readonly FindCustomerBySsn _findCustomer = findCustomer;

    [HttpPut]
    public ActionResult Update([Required, StringLength(9)] string ssn, [FromBody, Required] UpdateCustomerDTO dto)
    {
        CustomerEntity customer = _findCustomer.FindBySsn(ssn);
        customer.Update(dto);
        _context.Update(customer);
        _context.SaveChanges();
        return NoContent();
    }
}
