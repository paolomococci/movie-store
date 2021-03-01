using System;
using System.Linq;
using System.Threading.Tasks;

namespace WelcomeBlazorApp.Data
{
    public class WeatherForecastService
    {
        public Task<WeatherForecast[]> GetForecastAsync(DateTime startDate)
        {
            var rng = new Random();
            return Task.FromResult(Enumerable.Range(1, 5).Select(index => new WeatherForecast
            {
                Date = startDate.AddDays(index),
                TemperatureC = rng.Next(-20, 55)
            }).ToArray());
        }
    }
}
