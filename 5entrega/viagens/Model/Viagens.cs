using System.ComponentModel.DataAnnotations.Schema;

namespace Viagens.Model
{

[Table("viagens")]
public class Viagem 
{



[Column("Id")]
public int Id { get; set; }

[Column("viagem_name")]
public string Name { get; set; } = string.Empty;

[Column("viagem_genre")] 
public string Genre { get; set; } = string.Empty;

[Column("viagem_url")] 
public string viagemURL { get; set; } = string.Empty;

[Column("viagem_price")]
public decimal Price { get; set; }



}

}