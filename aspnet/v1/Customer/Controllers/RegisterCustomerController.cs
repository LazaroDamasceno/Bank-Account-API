using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;
using v1.Customer.DTOs;

namespace v1.Customer.Controllers;

[Route("api/v1/customer")]
[ApiController]
public class RegisterCustomerController(AppDbContext context) : ControllerBase
{
    private readonly AppDbContext _context = context;

    [HttpPost]
    public ActionResult Register([FromBody, Required] RegisterCustomerDTO dto)
    {
        CustomerEntity customer = CustomerEntity.CreateInstance(dto);
        _context.Add(customer);
        _context.SaveChanges();
        return Created();
    }
}
