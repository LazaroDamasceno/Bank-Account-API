using Microsoft.AspNetCore.Mvc;
using v1.BankAccount;
using v1.Customer;

namespace v1;

[Route("api/v1")]
[ApiController]
public class ClearAPIController(AppDbContext context) : ControllerBase
{
    private AppDbContext _context = context;

    [HttpDelete]
    public ActionResult Clean()
    {
        List<BankAccountEntity> bankAccounts = [.. _context.BankAccounts];
        _context.RemoveRange(bankAccounts);
        List<CustomerEntity> customers = [.. _context.Customers];
        _context.RemoveRange(customers);
        _context.SaveChanges();
        return NoContent();
    }
}
