using Microsoft.EntityFrameworkCore;
using v1.BankAccount;
using v1.Customer;

namespace v1;

public class AppDbContext : DbContext
{
    public DbSet<CustomerEntity> Customers { get; set; }
    public DbSet<BankAccountEntity> BankAccounts { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlite("Datasource=mydb.db;Cache=Shared");
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<CustomerEntity>().HasIndex(e => e.Ssn).IsUnique();

        modelBuilder.Entity<CustomerEntity>().HasIndex(e => e.Email).IsUnique();
    }
}
