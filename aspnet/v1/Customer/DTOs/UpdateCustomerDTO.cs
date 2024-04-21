using System.ComponentModel.DataAnnotations;

namespace v1.Customer.DTOs;

public record UpdateCustomerDTO(
    [Required]
    string FullName,

    [Required]
    DateOnly  BirthDate,

    [Required]
    string Address,

    [Required, EmailAddress]
    string Email,

    [Required, MinLength(1)]
    string Gender
)
{
}
