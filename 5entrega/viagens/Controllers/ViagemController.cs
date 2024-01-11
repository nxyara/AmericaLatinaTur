using Viagens.Model;
using Viagens.Data;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace Viagens.Controllers
{

[ApiController]
[Route("api/[controller]")]

    public class ViagemController : ControllerBase
    {

        private readonly DataContext _dataContext;


        public ViagemController(DataContext dataContext) {
            _dataContext = dataContext;
        }

    [HttpGet]public async Task<ActionResult<IEnumerable<Viagem>>> GetViagens()
    {
      return await _dataContext.Viagens.ToListAsync();
    }

    [HttpGet("{id}")]
    public async Task<ActionResult<Viagem>> GetViagemById(int id)
    {
      var viagem = await _dataContext.Viagens.FindAsync(id);
        if (viagem == null)
        {
         return NotFound();
        }

      return Ok(viagem);
    }

  }

}
