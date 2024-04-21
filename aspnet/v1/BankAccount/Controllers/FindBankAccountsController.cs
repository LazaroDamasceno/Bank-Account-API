using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace v1.BankAccount.Controllers;

[Route("api/v1/bank-accounts")]
[ApiController]
public class FindBankAccountsController(AppDbContext context) : ControllerBase
{
    private readonly AppDbContext _context = context;

    [HttpGet]
    public ActionResult<List<BankAccountEntity>> FindAll()
    {
        return Ok(_context.BankAccounts.ToList());
    }
}
