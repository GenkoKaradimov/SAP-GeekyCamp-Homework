using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Phonebook.Entities;

namespace Phonebook.Controllers
{
	public class HomeController : Controller
	{
		private readonly Context _context;

		public HomeController(Context context)
		{
			_context = context;
		}

		[HttpDelete]
		public IActionResult Delete(int id)
		{
			var record = _context.Records.FirstOrDefault(x => x.Id == id);

			if(record == null)
				return RedirectToAction("Index");

			_context.Records.Remove(record);
			_context.SaveChanges();

			return RedirectToAction("Index");
		}
	}
}
