const fs = require("fs");
const fetch = (...args) =>
  import("node-fetch").then(({ default: fetch }) => fetch(...args));

const API_URL = "https://malanjari.com/api/maps/all";

(async () => {
  const res = await fetch(API_URL);
  const data = await res.json();

  const urls = data.MapNameList.map((item) => {
    const loc = `https://malanjari.com/jari/${encodeURIComponent(
      item.mapName
    )}`;
    const lastmod = new Date().toISOString().split("T")[0];

    return `
  <url>
    <loc>${loc}</loc>
    <lastmod>${lastmod}</lastmod>
    <changefreq>daily</changefreq>
    <priority>0.8</priority>
  </url>`;
  });

  const sitemap = `<?xml version="1.0" encoding="UTF-8"?>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
  <url>
    <loc>https://malanjari.com/</loc>
    <lastmod>${new Date().toISOString().split("T")[0]}</lastmod>
    <changefreq>daily</changefreq>
    <priority>1.0</priority>
  </url>
  ${urls.join("\n")}
</urlset>`;

  fs.writeFileSync("public/sitemap.xml", sitemap);
  console.log("✅ sitemap.xml 생성 완료");
})();
