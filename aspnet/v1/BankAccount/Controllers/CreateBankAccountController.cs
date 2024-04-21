using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;
using v1.Customer;
using v1.Customer.Services;

namespace v1.BankAccount.Controllers;

[ApiController]
[Route("api/v1/bank-account")]
public class CreateBankAccountController(AppDbContext context, FindCustomerBySsn findCustomer) : ControllerBase
{
    private readonly AppDbContext _context = context;
    private readonly FindCustomerBySsn _findCustomer = findCustomer;

    [HttpPost("{ssn}")]
    public ActionResult Create([Required, StringLength(9)] string ssn)
    {
        CustomerEntity customer = _findCustomer.FindBySsn(ssn);
        BankAccountEntity bankAccount = new()
        {
            CustomerId = customer.Id,
        };
        _context.Add(bankAccount);
        _context.SaveChanges();
        return Created();
    }
}
