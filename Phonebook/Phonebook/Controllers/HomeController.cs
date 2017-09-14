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

		[HttpGet]
		public IActionResult Index()
		{
			return View();
		}
	}
}
