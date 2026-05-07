package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageCaption;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;

public class Mybot extends TelegramLongPollingBot {

    // ════════════════════════════════════════════════════════════════
    //  MAHSULOTLAR: id | nomi | narxi | rasm_url | tavsif
    // ════════════════════════════════════════════════════════════════
    private static final String[][] PRODUCTS = {

            // ── iPhone ──────────────────────────────────────────────
            {
                    "iphone14",
                    "iPhone 14",
                    "799$",
                    "https://www.machines.com.my/cdn/shop/products/iPhone_14_Starlight_PDP_Image_Position-1A__WWEN.jpg?v=1705598575&width=823",
                    "⚡️ *Chip:* A15 Bionic (4-yadro GPU)\n"
                            + "🖥 *Ekran:* 6.1\" Super Retina XDR, 460 ppi\n"
                            + "🌈 *Ranglar:* Midnight, Starlight, Blue, Purple, Red\n"
                            + "💾 *Xotira:* 128GB / 256GB / 512GB\n"
                            + "🧠 *RAM:* 6GB\n"
                            + "📸 *Kamera:* 12MP Dual (asosiy + ultra wide)\n"
                            + "🤳 *Front:* 12MP TrueDepth, autofocus\n"
                            + "🔋 *Batareya:* 3279 mAh — 20 soat video\n"
                            + "🛡 *Korpus:* Ceramic Shield, IP68\n"
                            + "📡 *Aloqa:* 5G + Wi-Fi 6 + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 172 g | *Qalinlik:* 7.8 mm"
            },
            {
                    "iphone15",
                    "iPhone 15",
                    "999$",
                    "https://www.wireless.walmart.ca/wp-content/uploads/2024/01/iPhone-15.jpg",
                    "⚡️ *Chip:* A16 Bionic (5-yadro GPU)\n"
                            + "🖥 *Ekran:* 6.1\" Super Retina XDR, 460 ppi\n"
                            + "🌈 *Ranglar:* Black, Blue, Green, Yellow, Pink\n"
                            + "💾 *Xotira:* 128GB / 256GB / 512GB\n"
                            + "🧠 *RAM:* 6GB\n"
                            + "📸 *Kamera:* 48MP asosiy + 12MP ultra wide\n"
                            + "🤳 *Front:* 12MP TrueDepth, autofocus\n"
                            + "🔋 *Batareya:* 3877 mAh — 26 soat video\n"
                            + "🔌 *Port:* USB-C (USB 2.0)\n"
                            + "🌈 *Dynamic Island* panel\n"
                            + "🛡 *Korpus:* Aluminum + Ceramic Shield, IP68\n"
                            + "📡 *Aloqa:* 5G + Wi-Fi 6 + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 171 g | *Qalinlik:* 7.8 mm"
            },
            {
                    "iphone15promax",
                    "iPhone 15 Pro Max",
                    "1 200$",
                    "https://i5.walmartimages.com/asr/9f6a74a7-82b2-4a35-a71b-85ce556d7df2.5725ab75a3b34b091c51d001f4afb136.jpeg",
                    "⚡️ *Chip:* A17 Pro (6-yadro GPU) — eng kuchli\n"
                            + "🖥 *Ekran:* 6.7\" Super Retina XDR ProMotion 120Hz\n"
                            + "🌈 *Ranglar:* Black Titanium, White, Blue, Natural\n"
                            + "💾 *Xotira:* 256GB / 512GB / 1TB\n"
                            + "🧠 *RAM:* 8GB\n"
                            + "📸 *Kamera:* 48MP + 12MP ultra wide + 12MP 5x telephoto\n"
                            + "🤳 *Front:* 12MP TrueDepth, autofocus\n"
                            + "🎥 *Video:* 4K 60fps ProRes, Log video\n"
                            + "🔋 *Batareya:* 4422 mAh — 29 soat video\n"
                            + "🔌 *Port:* USB-C (USB 3 — 10Gb/s)\n"
                            + "🛡 *Korpus:* Titanium + Ceramic Shield, IP68\n"
                            + "📡 *Aloqa:* 5G + Wi-Fi 6E + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 221 g | *Qalinlik:* 8.25 mm"
            },
            {
                    "iphone16",
                    "iPhone 16",
                    "1 099$",
                    "https://store.storeimages.cdn-apple.com/1/as-images.apple.com/is/iphone-16-plus-pink-witb-202409_FMT_WHH?wid=560&hei=744&fmt=jpeg&qlt=90&.v=LzF1SmZDTmUzL1QxQ2JXNHpEZjMrYUMzU3p1RHloN3dISUQ0OW16L1c3c0d1R1RTRmZxcldhaTc4Q2w3K0FJTng1cU1LaVA3emtIaXgrdGhmdjJJQjdibzVJOUNDdkxwZ3NZOTJEaWVpTk1TU0FnbHF5NUJsUGdyckNkdzFZaXc",
                    "⚡️ *Chip:* A18 (AI uchun maxsus Neural Engine)\n"
                            + "🖥 *Ekran:* 6.1\" Super Retina XDR, 460 ppi\n"
                            + "🌈 *Ranglar:* Black, White, Pink, Teal, Ultramarine\n"
                            + "💾 *Xotira:* 128GB / 256GB / 512GB\n"
                            + "🧠 *RAM:* 8GB\n"
                            + "📸 *Kamera:* 48MP Fusion + 12MP ultra wide\n"
                            + "🤳 *Front:* 12MP TrueDepth, autofocus\n"
                            + "🎬 *Camera Control:* yangi maxsus tugma\n"
                            + "🤖 *Apple Intelligence* — AI funksiyalar\n"
                            + "🔋 *Batareya:* 3561 mAh — 22 soat video\n"
                            + "🔌 *Port:* USB-C (USB 3)\n"
                            + "🛡 *Korpus:* Aluminum + Ceramic Shield, IP68\n"
                            + "📡 *Aloqa:* 5G + Wi-Fi 7 + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 170 g | *Qalinlik:* 7.8 mm"
            },

            {
                    "macbook_air_m2",
                    "MacBook Air M2 13\"",
                    "1 099$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/macbook-air-midnight-select-20220606?wid=800&hei=800&fmt=jpeg",
                    "⚡️ *Chip:* Apple M2 (8-yadro CPU, 8-yadro GPU)\n"
                            + "🖥 *Ekran:* 13.6\" Liquid Retina, 2560×1664, 224 ppi\n"
                            + "🌈 *Ranglar:* Midnight, Starlight, Silver, Space Gray\n"
                            + "🧠 *RAM:* 8GB / 16GB / 24GB Unified Memory\n"
                            + "💾 *SSD:* 256GB / 512GB / 1TB / 2TB\n"
                            + "📷 *Kamera:* 1080p FaceTime HD\n"
                            + "🔊 *Audio:* 4-dinamikli Spatial Audio\n"
                            + "🔋 *Batareya:* 52.6 Wh — 18 soat\n"
                            + "🌬 *Sovutish:* Ventilyatorsiz — jimjit\n"
                            + "🔌 *Portlar:* 2x Thunderbolt 4 + MagSafe 3\n"
                            + "📡 *Aloqa:* Wi-Fi 6 + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 1.24 kg | *Qalinlik:* 11.3 mm"
            },
            {
                    "macbook",
                    "MacBook Pro M3 14\"",
                    "1 800$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mbp14-spacegray-select-202310?wid=800&hei=800&fmt=jpeg",
                    "⚡️ *Chip:* Apple M3 (8-yadro CPU, 10-yadro GPU)\n"
                            + "🖥 *Ekran:* 14.2\" Liquid Retina XDR, 3024×1964, ProMotion 120Hz\n"
                            + "🌈 *Ranglar:* Space Black, Silver\n"
                            + "🧠 *RAM:* 8GB / 16GB / 24GB Unified Memory\n"
                            + "💾 *SSD:* 512GB / 1TB / 2TB\n"
                            + "📷 *Kamera:* 1080p FaceTime HD\n"
                            + "🎙 *Audio:* 6-mikrofon + 6-dinamik Spatial Audio\n"
                            + "🔋 *Batareya:* 70 Wh — 18 soat\n"
                            + "🔌 *Portlar:* 3x Thunderbolt 4 + HDMI + SD + MagSafe 3\n"
                            + "📡 *Aloqa:* Wi-Fi 6E + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 1.55 kg | *Qalinlik:* 15.5 mm"
            },
            {
                    "macbook_pro_m3_16",
                    "MacBook Pro M3 16\"",
                    "2 499$",
                    "https://ipowerresale.com/cdn/shop/files/media_1ba64fd6-03c9-4f15-9e9e-3d27e78e42b3.png?v=1766098090",
                    "⚡️ *Chip:* Apple M3 Pro (12-yadro CPU, 18-yadro GPU)\n"
                            + "🖥 *Ekran:* 16.2\" Liquid Retina XDR, 3456×2234, ProMotion 120Hz\n"
                            + "🌈 *Ranglar:* Space Black, Silver\n"
                            + "🧠 *RAM:* 18GB / 36GB Unified Memory\n"
                            + "💾 *SSD:* 512GB / 1TB / 2TB / 4TB\n"
                            + "📷 *Kamera:* 1080p FaceTime HD\n"
                            + "🎙 *Audio:* 6-mikrofon + 6-dinamik Spatial Audio, Dolby Atmos\n"
                            + "🔋 *Batareya:* 100 Wh — 22 soat\n"
                            + "🔌 *Portlar:* 3x Thunderbolt 4 + HDMI 2.1 + SD + MagSafe 3\n"
                            + "📡 *Aloqa:* Wi-Fi 6E + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 2.14 kg | *Qalinlik:* 16.8 mm"
            },
            {
                    "macbook_air_m3",
                    "MacBook Air M3 15\"",
                    "1 299$",
                    "https://mybyte.com.au/cdn/shop/articles/My_Byte_MacBook_Air_M3_Specs_Blog.png?v=1733811778&width=1800",
                    "⚡️ *Chip:* Apple M3 (8-yadro CPU, 10-yadro GPU)\n"
                            + "🖥 *Ekran:* 15.3\" Liquid Retina, 2880×1864, 224 ppi\n"
                            + "🌈 *Ranglar:* Midnight, Starlight, Silver, Space Gray\n"
                            + "🧠 *RAM:* 8GB / 16GB / 24GB Unified Memory\n"
                            + "💾 *SSD:* 256GB / 512GB / 1TB / 2TB\n"
                            + "📷 *Kamera:* 1080p FaceTime HD\n"
                            + "🔊 *Audio:* 6-dinamikli Spatial Audio\n"
                            + "🔋 *Batareya:* 66.5 Wh — 18 soat\n"
                            + "🌬 *Sovutish:* Ventilyatorsiz — jimjit\n"
                            + "🔌 *Portlar:* 2x Thunderbolt 4 + MagSafe 3\n"
                            + "📡 *Aloqa:* Wi-Fi 6E + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 1.51 kg | *Qalinlik:* 11.5 mm"
            },

            // ── Apple Watch ─────────────────────────────────────────
            {
                    "watch_s8",
                    "Apple Watch Series 8",
                    "399$",
                    "https://ozmobiles.com.au/cdn/shop/files/apple-watch-series-8-gold_1000x.jpg?v=1729136077",
                    "⚡️ *Chip:* S8 SiP dual-core\n"
                            + "🖥 *Ekran:* 45mm LTPO OLED — 2000 nit\n"
                            + "🌈 *Ranglar:* Midnight, Starlight, Silver, Gold, Red\n"
                            + "❤️ *Sensorlar:* Yurak ritmi, EKG, SpO2\n"
                            + "🌡 *Harorat sensori:* Tana haroratini o'lchaydi\n"
                            + "💥 *Crash Detection:* Avaria aniqlash\n"
                            + "🏃 *Sport:* 80+ faoliyat turi\n"
                            + "💧 *Himoya:* WR50 (50m suv osti)\n"
                            + "🔋 *Batareya:* 18 soat | fast charge\n"
                            + "📡 *Aloqa:* GPS + Cellular + Wi-Fi + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 42.3 g (aluminum)"
            },
            {
                    "watch",
                    "Apple Watch Series 9",
                    "500$",
                    "https://www.apple.com/newsroom/videos/apple-watch-series-9/posters/Apple-Watch-S9-Precision-Finding-230912.jpg.large_2x.jpg",
                    "⚡️ *Chip:* S9 SiP dual-core — 2x tezroq Siri\n"
                            + "🖥 *Ekran:* 45mm LTPO OLED — 2000 nit\n"
                            + "🌈 *Ranglar:* Midnight, Starlight, Silver, Pink, Red\n"
                            + "❤️ *Sensorlar:* Yurak ritmi, EKG, SpO2, Harorat\n"
                            + "👆 *Double Tap:* qo'lni silkitib boshqarish\n"
                            + "🏃 *Sport:* 100+ faoliyat turi\n"
                            + "💧 *Himoya:* WR50 (50m suv osti)\n"
                            + "🔋 *Batareya:* 18 soat | 60% — 45 daqiqa fast charge\n"
                            + "📡 *Aloqa:* GPS + Cellular + Wi-Fi 6 + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 42.3 g (aluminum) / 51.5 g (stainless)"
            },
            {
                    "watch_ultra2",
                    "Apple Watch Ultra 2",
                    "799$",
                    "https://frankfurt.apollo.olxcdn.com/v1/files/nwy2op14jix42-UZ/image",
                    "⚡️ *Chip:* S9 SiP — eng kuchli soat\n"
                            + "🖥 *Ekran:* 49mm LTPO OLED — 3000 nit (rekord!)\n"
                            + "🌈 *Ranglar:* Natural / Black Titanium\n"
                            + "🏔 *Maqsad:* Ekstremal sport va sarguzashtlar\n"
                            + "❤️ *Sensorlar:* Yurak ritmi, EKG, SpO2, Harorat, Chuqurlik\n"
                            + "🌊 *Himoya:* 100m suv osti (EN13319 sertifikat)\n"
                            + "🌡 *Temperatura:* -20°C dan +55°C gacha\n"
                            + "📡 *GPS:* Dual-frequency L1+L5 — eng aniq\n"
                            + "🔋 *Batareya:* 60 soat oddiy | 36 soat Low Power\n"
                            + "🛡 *Korpus:* Grade 5 Titanium — eng mustahkam\n"
                            + "⚖️ *Og'irlik:* 61.4 g"
            },
            {
                    "watch_se2",
                    "Apple Watch SE 2",
                    "249$",
                    "https://apple.directd.com.my/images/thumbs/0003973_apple-watch-se-2023-2nd-generation_625.webp",
                    "⚡️ *Chip:* S8 SiP dual-core\n"
                            + "🖥 *Ekran:* 44mm LTPO OLED — 1000 nit\n"
                            + "🌈 *Ranglar:* Midnight, Starlight, Silver\n"
                            + "❤️ *Sensorlar:* Yurak ritmi, SpO2 (EKG yo'q)\n"
                            + "💥 *Crash + Fall Detection:* aniqlash tizimi\n"
                            + "🏃 *Sport:* 50+ faoliyat turi\n"
                            + "💧 *Himoya:* WR50 (50m suv osti)\n"
                            + "🔋 *Batareya:* 18 soat\n"
                            + "💰 *Narx:* Eng qulay va samarali tanlov\n"
                            + "📡 *Aloqa:* GPS + Cellular + Wi-Fi + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 36.4 g (aluminum)"
            },

            // ── AirPods ─────────────────────────────────────────────
            {
                    "airpods3",
                    "AirPods 3",
                    "179$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MME73?wid=800&hei=800&fmt=jpeg",
                    "🎵 *Audio:* Spatial Audio — 360° dinamik tovush\n"
                            + "🔊 *Drayveri:* Custom high-excursion Apple driver\n"
                            + "🎙 *Mikrofon:* Dual beamforming — shovqin bloklash\n"
                            + "🔇 *ANC:* Yo'q (ANC faqat Pro modellarda)\n"
                            + "🌈 *Rang:* White\n"
                            + "💧 *Himoya:* IPX4 (suv va ter himoyasi)\n"
                            + "🔋 *Quloqchin:* 6 soat | *Quti bilan:* 30 soat\n"
                            + "⚡️ *Zaryad:* MagSafe + Lightning\n"
                            + "👆 *Boshqaruv:* Force sensor siqish\n"
                            + "📡 *Aloqa:* Bluetooth 5.0 | Chip: H1\n"
                            + "⚖️ *Og'irlik:* 4.28 g (har bir quloqchin)"
            },
            {
                    "airpods",
                    "AirPods Pro 2",
                    "300$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MQD83?wid=800&hei=800&fmt=jpeg",
                    "🔇 *ANC:* Active Noise Cancellation — 2x kuchliroq\n"
                            + "🎵 *Audio:* Personalized Spatial Audio — 360°\n"
                            + "🗣 *Transparency Mode:* ambient tovushni o'tkazadi\n"
                            + "🌈 *Rang:* White\n"
                            + "💧 *Himoya:* IP54 (quloqchin + quti)\n"
                            + "🔋 *Quloqchin:* 6 soat ANC bilan | *Quti:* 30 soat\n"
                            + "⚡️ *Zaryad:* MagSafe + Lightning\n"
                            + "⌚️ *Apple Watch bilan:* simsiz zaryadlash\n"
                            + "👆 *Boshqaruv:* Touch control + ovoz balandligi\n"
                            + "📡 *Aloqa:* Bluetooth 5.3 | Chip: H2\n"
                            + "⚖️ *Og'irlik:* 5.3 g (har bir quloqchin)"
            },
            {
                    "airpods_max",
                    "AirPods Max",
                    "549$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/airpods-max-select-202409-midnight?wid=800&hei=800&fmt=jpeg",
                    "🔇 *ANC:* Industry-leading shovqin bekor qilish\n"
                            + "🎵 *Audio:* Hi-Fi Spatial Audio — professional sifat\n"
                            + "🎧 *Turi:* Over-ear — to'liq quloqni qoplaydi\n"
                            + "🌈 *Ranglar:* Midnight, Starlight, Blue, Purple, Orange\n"
                            + "🔊 *Drayveri:* 40mm custom dynamic driver\n"
                            + "🎙 *Mikrofon:* 9 ta mikrofon — 3D Dolby Atmos\n"
                            + "💅 *Material:* Premium mesh headband + knit mesh qopqoq\n"
                            + "🔋 *Batareya:* 20 soat ANC bilan\n"
                            + "🔌 *Zaryad:* USB-C\n"
                            + "📡 *Aloqa:* Bluetooth 5.0 | Chip: H1\n"
                            + "⚖️ *Og'irlik:* 385 g"
            },
            {
                    "airpods_pro2_usbc",
                    "AirPods Pro 2 USB-C",
                    "279$",
                    "https://image-cdn.hypb.st/https%3A%2F%2Fhypebeast.com%2Fimage%2F2023%2F03%2Fapple-rumored-to-release-airpods-pro-2-usb-c-charging-port-info-000.jpg?w=960&cbr=1&q=90&fit=max",
                    "🔇 *ANC:* 2x kuchliroq Active Noise Cancellation\n"
                            + "🎵 *Audio:* Personalized Spatial Audio — 360°\n"
                            + "🗣 *Adaptive Audio:* ANC + Transparency avtomatik\n"
                            + "🎙 *Conversation Awareness:* gaplashsangiz audio pasayadi\n"
                            + "🌈 *Rang:* White\n"
                            + "💧 *Himoya:* IP54 (quloqchin + quti)\n"
                            + "🔋 *Quloqchin:* 6 soat ANC bilan | *Quti:* 30 soat\n"
                            + "🔌 *Zaryad:* USB-C quti (iPhone 15 bilan mos!)\n"
                            + "👆 *Boshqaruv:* Touch + ovoz balandligi swipe\n"
                            + "📡 *Aloqa:* Bluetooth 5.3 | Chip: H2\n"
                            + "⚖️ *Og'irlik:* 5.3 g (har bir quloqchin)"
            },

            // ── iPad ────────────────────────────────────────────────
            {
                    "ipad_mini6",
                    "iPad mini 6",
                    "499$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/ipad-mini-select-wifi-purple-202109?wid=800&hei=800&fmt=jpeg",
                    "⚡️ *Chip:* A15 Bionic (5-yadro GPU)\n"
                            + "🖥 *Ekran:* 8.3\" Liquid Retina, 2266×1488, 326 ppi\n"
                            + "🌈 *Ranglar:* Space Gray, Pink, Purple, Starlight\n"
                            + "🧠 *RAM:* 4GB\n"
                            + "💾 *Xotira:* 64GB / 256GB\n"
                            + "📷 *Asosiy kamera:* 12MP f/1.8\n"
                            + "🤳 *Front kamera:* 12MP ultrawide — Center Stage\n"
                            + "✏️ *Qalam:* Apple Pencil 2 (siqib zaryadlash)\n"
                            + "🔌 *Port:* USB-C\n"
                            + "🔋 *Batareya:* 19.3 Wh — 10 soat\n"
                            + "📡 *Aloqa:* 5G + Wi-Fi 6 + Bluetooth 5.0\n"
                            + "⚖️ *Og'irlik:* 293 g | *Qalinlik:* 6.3 mm"
            },
            {
                    "ipad_air_m1",
                    "iPad Air M1 10.9\"",
                    "749$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/ipad-air-select-wifi-blue-202203?wid=800&hei=800&fmt=jpeg",
                    "⚡️ *Chip:* Apple M1 (8-yadro CPU, 7-yadro GPU)\n"
                            + "🖥 *Ekran:* 10.9\" Liquid Retina, 2360×1640, 264 ppi\n"
                            + "🌈 *Ranglar:* Space Gray, Starlight, Pink, Purple, Blue\n"
                            + "🧠 *RAM:* 8GB\n"
                            + "💾 *Xotira:* 64GB / 256GB\n"
                            + "📷 *Asosiy kamera:* 12MP f/1.8\n"
                            + "🤳 *Front kamera:* 12MP ultrawide — Center Stage\n"
                            + "✏️ *Qalam:* Apple Pencil 2\n"
                            + "⌨️ *Klaviatura:* Magic Keyboard qo'llab-quvvatlash\n"
                            + "🔌 *Port:* USB-C (USB 3.1 Gen 2)\n"
                            + "🔋 *Batareya:* 28.65 Wh — 10 soat\n"
                            + "📡 *Aloqa:* 5G + Wi-Fi 6E + Bluetooth 5.0\n"
                            + "⚖️ *Og'irlik:* 461 g | *Qalinlik:* 6.1 mm"
            },
            {
                    "ipad",
                    "iPad Pro M2 12.9\"",
                    "999$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/ipad-pro-13-select-cell-spacegray-202210?wid=800&hei=800&fmt=jpeg",
                    "⚡️ *Chip:* Apple M2 (8-yadro CPU, 10-yadro GPU)\n"
                            + "🖥 *Ekran:* 12.9\" Liquid Retina XDR mini-LED, 2732×2048, 264 ppi\n"
                            + "🌈 *Ranglar:* Space Gray, Silver\n"
                            + "🧠 *RAM:* 8GB / 16GB\n"
                            + "💾 *Xotira:* 128GB / 256GB / 512GB / 1TB / 2TB\n"
                            + "📷 *Asosiy kamera:* 12MP wide + 10MP ultrawide\n"
                            + "🔬 *LiDAR:* 3D skaner sensori\n"
                            + "🤳 *Front kamera:* 12MP ultrawide — Center Stage\n"
                            + "✏️ *Qalam:* Apple Pencil 2 (hover qo'llab-quvvatlash)\n"
                            + "🔌 *Port:* Thunderbolt 4 (USB4, 40Gb/s)\n"
                            + "🔋 *Batareya:* 40.88 Wh — 10 soat\n"
                            + "📡 *Aloqa:* 5G + Wi-Fi 6E + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 682 g | *Qalinlik:* 6.4 mm"
            },
            {
                    "ipad_pro_m4",
                    "iPad Pro M4 13\"",
                    "1 299$",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGZCH-kV1mFMfrbtwCe_GpxNLj3gNyzMS82Q&s",
                    "⚡️ *Chip:* Apple M4 (10-yadro CPU, 10-yadro GPU) — eng zamonaviy\n"
                            + "🖥 *Ekran:* 13\" Ultra Retina XDR tandem OLED, 2752×2064\n"
                            + "🌈 *Ranglar:* Space Black, Silver\n"
                            + "🧠 *RAM:* 8GB / 16GB / 32GB\n"
                            + "💾 *Xotira:* 256GB / 512GB / 1TB / 2TB\n"
                            + "📷 *Kamera:* 12MP wide + 10MP ultrawide (LiDAR bilan)\n"
                            + "🤳 *Front:* 12MP ultrawide — Center Stage + TrueDepth\n"
                            + "✏️ *Qalam:* Apple Pencil Pro (yangi siqish + gyroscope)\n"
                            + "⚖️ *Qalinlik:* 5.1 mm — eng yupqa iPad ever!\n"
                            + "🔌 *Port:* Thunderbolt 4 + Wi-Fi 6E\n"
                            + "🔋 *Batareya:* 38.99 Wh — 10 soat\n"
                            + "📡 *Aloqa:* 5G + Wi-Fi 6E + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* 579 g (Wi-Fi) | *Qalinlik:* 5.1 mm"
            },

            // ── HomePod ─────────────────────────────────────────────
            {
                    "homepod_mini",
                    "HomePod mini",
                    "99$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/homepod-mini-select-yellow-202210?wid=800&hei=800&fmt=jpeg",
                    "⚡️ *Chip:* Apple S5\n"
                            + "🔊 *Audio:* 360° full-range speaker — xona to'liq tovush\n"
                            + "🎙 *Mikrofon:* 4 ta mikrofon — \"Hey Siri\" doim tayyor\n"
                            + "🌡 *Sensor:* Harorat va namlik o'lchagich (built-in)\n"
                            + "🏠 *Smart Home:* HomeKit + Matter + Thread hub\n"
                            + "📱 *Intercom:* boshqa HomePod bilan gaplashish\n"
                            + "🎨 *Ranglar:* White, Midnight, Yellow, Orange, Blue\n"
                            + "🔌 *Quvvat:* o'rnatilgan kabel — 20W\n"
                            + "📡 *Aloqa:* Wi-Fi 4 + Bluetooth 5.0 + Ultra Wideband\n"
                            + "📏 *O'lcham:* 84.3 mm balandlik | *Og'irlik:* 345 g"
            },
            {
                    "homepod2",
                    "HomePod 2nd Gen",
                    "299$",
                    "https://gadgetshouse.com.cy/wp-content/uploads/2024/10/homepod-select-white-202210_FMT_WHH.jpeg",
                    "⚡️ *Chip:* Apple S9\n"
                            + "🔊 *Audio:* Room-sensing — xona akustikasini avtomatik sozlash\n"
                            + "🎵 *Dolby Atmos:* 3D surround sound\n"
                            + "🎙 *Mikrofon:* 6 ta mikrofon — aniq ovoz aniqlash\n"
                            + "🔈 *Dinamiklar:* 1 ta high-excursion woofer + 5 ta tweeter\n"
                            + "🌡 *Sensor:* Harorat va namlik o'lchagich\n"
                            + "🏠 *Smart Home:* HomeKit + Matter + Thread hub\n"
                            + "🌈 *Ranglar:* White, Midnight\n"
                            + "🔌 *Quvvat:* o'rnatilgan kabel — 20W\n"
                            + "📡 *Aloqa:* Wi-Fi 6 + Bluetooth 5.3 + Ultra Wideband\n"
                            + "📏 *O'lcham:* 168 mm balandlik | *Og'irlik:* 2.3 kg"
            },
            {
                    "homepod_mini_orange",
                    "HomePod mini Orange",
                    "99$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/homepod-mini-select-orange-202210?wid=800&hei=800&fmt=jpeg",
                    "⚡️ *Chip:* Apple S5\n"
                            + "🍊 *Rang:* Chiroyli Orange — interyer bezagi\n"
                            + "🔊 *Audio:* 360° Computational audio — aqlli tovush\n"
                            + "🎙 *Mikrofon:* 4 ta mikrofon — \"Hey Siri\" always-on\n"
                            + "🌡 *Sensor:* Harorat va namlik o'lchagich\n"
                            + "🏠 *Smart Home:* HomeKit + Matter + Thread hub\n"
                            + "📱 *Intercom:* Barcha HomePod bilan ulanish\n"
                            + "🔌 *Quvvat:* o'rnatilgan kabel — 20W\n"
                            + "📡 *Aloqa:* Wi-Fi 4 + Bluetooth 5.0 + Ultra Wideband\n"
                            + "📏 *O'lcham:* 84.3 mm balandlik | *Og'irlik:* 345 g"
            },
            {
                    "homepod_mini_blue",
                    "HomePod mini Blue",
                    "99$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/homepod-mini-select-blue-202210?wid=800&hei=800&fmt=jpeg",
                    "⚡️ *Chip:* Apple S5\n"
                            + "🔵 *Rang:* Chiroyli Blue — zamonaviy dizayn\n"
                            + "🔊 *Audio:* 360° full-room Computational audio\n"
                            + "🎙 *Mikrofon:* 4 ta mikrofon — qo'lsiz boshqaruv\n"
                            + "🌡 *Sensor:* Harorat va namlik o'lchagich\n"
                            + "🏠 *HomeKit + Intercom:* uy avtomatikasi\n"
                            + "📱 *iPhone Handoff:* musiqani darhol uzatish\n"
                            + "🔌 *Quvvat:* o'rnatilgan kabel — 20W\n"
                            + "📡 *Aloqa:* Wi-Fi 4 + Bluetooth 5.0 + Ultra Wideband\n"
                            + "📏 *O'lcham:* 84.3 mm balandlik | *Og'irlik:* 345 g"
            },

            // ── Vision Pro ──────────────────────────────────────────
            {
                    "vision_256",
                    "Apple Vision Pro 256GB",
                    "3 499$",
                    "https://www.mcsteve.com/wp-content/uploads/2024/06/vision-pro-1.jpeg",
                    "🥽 *Texnologiya:* Spatial computing — yangi era\n"
                            + "⚡️ *Chip:* M2 (kompyuter) + R1 (real-time sensor ishlov)\n"
                            + "👁 *Displey:* micro-OLED 23 megapiksel (har bir ko'z uchun)\n"
                            + "🧠 *RAM:* 16GB Unified Memory\n"
                            + "💾 *Xotira:* 256GB\n"
                            + "📷 *Kamera:* 12 kamera + 5 sensor + 6 mikrofon\n"
                            + "👁 *Ko'z boshqaruvi:* Eye tracking — qarash bilan tanlov\n"
                            + "🖐 *Qo'l imo:* Hand gesture — tegilmasdan boshqaruv\n"
                            + "🔊 *Audio:* Personalized Spatial Audio\n"
                            + "🔋 *Batareya:* 2 soat (tashqi) | USB-C zaryadlash\n"
                            + "📡 *Aloqa:* Wi-Fi 6E + Bluetooth 5.3 + USB-C\n"
                            + "⚖️ *Og'irlik:* ~600 g (bosh qismi)"
            },
            {
                    "vision",
                    "Apple Vision Pro 512GB",
                    "3 699$",
                    "https://cdn.mediapark.uz/imgs/a0288113-dc43-4e62-96a9-392beea898bf_Artboard-15.webp",
                    "🥽 *Texnologiya:* Spatial computing — yangi era\n"
                            + "⚡️ *Chip:* M2 (kompyuter) + R1 (real-time sensor)\n"
                            + "👁 *Displey:* micro-OLED 23 megapiksel (har bir ko'z)\n"
                            + "🧠 *RAM:* 16GB Unified Memory\n"
                            + "💾 *Xotira:* 512GB — katta hajm\n"
                            + "📷 *Kamera:* 12 kamera + 5 sensor + 6 mikrofon\n"
                            + "👁 *Ko'z boshqaruvi:* Eye tracking — qarash bilan tanlov\n"
                            + "🖐 *Qo'l imo:* Hand gesture boshqaruv\n"
                            + "🔊 *Audio:* Personalized Spatial Audio\n"
                            + "🔋 *Batareya:* 2 soat (tashqi) | USB-C zaryadlash\n"
                            + "📡 *Aloqa:* Wi-Fi 6E + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* ~600 g"
            },
            {
                    "vision_1tb",
                    "Apple Vision Pro 1TB",
                    "3 899$",
                    "https://apple-people.com.ua/content/images/32/536x536l50bc50/12161132573819.jpg",
                    "🥽 *Texnologiya:* Spatial computing — eng yuqori model\n"
                            + "⚡️ *Chip:* M2 + R1 — eng tez AR/VR ishlov\n"
                            + "👁 *Displey:* micro-OLED 23 megapiksel (har bir ko'z)\n"
                            + "🧠 *RAM:* 16GB Unified Memory\n"
                            + "💾 *Xotira:* 1TB — maksimal hajm\n"
                            + "📷 *Kamera:* 12 kamera + 5 sensor + 6 mikrofon\n"
                            + "👁 *Ko'z + Ovoz + Qo'l:* tripl boshqaruv tizimi\n"
                            + "🎮 *3D kontent:* Apple Immersive Video, 3D filmlar\n"
                            + "🔊 *Audio:* Personalized Spatial Audio\n"
                            + "🔋 *Batareya:* 2 soat (tashqi) | USB-C\n"
                            + "📡 *Aloqa:* Wi-Fi 6E + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* ~600 g"
            },
            {
                    "vision_dev",
                    "Apple Vision Pro Developer",
                    "3 499$",
                    "https://www.idropnews.com/wp-content/uploads/2023/06/Apple-WWCD23-Vision-Pro.jpg",
                    "🥽 *Maqsad:* Dasturchilar uchun maxsus to'plam\n"
                            + "⚡️ *Chip:* M2 + R1\n"
                            + "👁 *Displey:* micro-OLED 23 megapiksel\n"
                            + "🧠 *RAM:* 16GB Unified Memory\n"
                            + "💾 *Xotira:* 256GB\n"
                            + "🛠 *SDK:* visionOS SDK — to'liq kirish\n"
                            + "🧪 *TestFlight:* ilovalarni test qilish\n"
                            + "🎮 *Xcode:* 3D va AR ilova ishlab chiqish\n"
                            + "📷 *Kamera:* 12 kamera + 5 sensor + 6 mikrofon\n"
                            + "🔋 *Batareya:* 2 soat (tashqi) | USB-C\n"
                            + "📡 *Aloqa:* Wi-Fi 6E + Bluetooth 5.3\n"
                            + "⚖️ *Og'irlik:* ~600 g"
            },

            // ── Mac mini / Mac Studio ────────────────────────────────
            {
                    "mac_mini",
                    "Mac mini M2",
                    "599$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mac-mini-hero-202301?wid=800&hei=800&fmt=jpeg",
                    "⚡️ *Chip:* Apple M2 (8-yadro CPU, 10-yadro GPU)\n"
                            + "🧠 *RAM:* 8GB / 16GB / 24GB Unified Memory\n"
                            + "💾 *SSD:* 256GB / 512GB / 1TB / 2TB\n"
                            + "🖥 *Displey:* Istalgan monitor bilan ishlaydi (2 tagacha)\n"
                            + "🔌 *Portlar:* 2x Thunderbolt 4 + 3x USB-A + HDMI 2.0\n"
                            + "🌐 *Tarmoq:* Wi-Fi 6E + Bluetooth 5.3 + Gigabit Ethernet\n"
                            + "🎙 *Audio:* 3.5mm jack (high-impedance qo'llab-quvvatlash)\n"
                            + "🌈 *Rang:* Silver\n"
                            + "📦 *O'lcham:* 197×197×35.8 mm — juda kichkina!\n"
                            + "⚖️ *Og'irlik:* 1.18 kg"
            },
            {
                    "mac_mini_m2pro",
                    "Mac mini M2 Pro",
                    "1 299$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mac-mini-hero-202301?wid=800&hei=800&fmt=jpeg",
                    "⚡️ *Chip:* Apple M2 Pro (12-yadro CPU, 19-yadro GPU)\n"
                            + "🧠 *RAM:* 16GB / 32GB Unified Memory\n"
                            + "💾 *SSD:* 512GB / 1TB / 2TB / 4TB\n"
                            + "🖥 *Displey:* 3 ta monitor bilan ishlaydi\n"
                            + "🔌 *Portlar:* 3x Thunderbolt 4 + 2x USB-A + HDMI 2.1\n"
                            + "🌐 *Tarmoq:* Wi-Fi 6E + Bluetooth 5.3 + 10Gb Ethernet\n"
                            + "🎙 *Audio:* 3.5mm high-impedance jack\n"
                            + "🌈 *Rang:* Silver\n"
                            + "📦 *O'lcham:* 197×197×35.8 mm\n"
                            + "⚖️ *Og'irlik:* 1.18 kg | Professional ish uchun ideal"
            },
            {
                    "mac_studio_m2",
                    "Mac Studio M2 Max",
                    "1 999$",
                    "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mac-studio-select-202306?wid=800&hei=800&fmt=jpeg",
                    "⚡️ *Chip:* Apple M2 Max (12-yadro CPU, 38-yadro GPU)\n"
                            + "🧠 *RAM:* 32GB / 64GB / 96GB Unified Memory\n"
                            + "💾 *SSD:* 512GB / 1TB / 2TB / 4TB / 8TB\n"
                            + "🖥 *Displey:* 5 ta monitor bilan ishlaydi\n"
                            + "🔌 *Portlar:* 6x Thunderbolt 4 + 2x USB-A + HDMI 2.1 + SD\n"
                            + "🌐 *Tarmoq:* Wi-Fi 6E + Bluetooth 5.3 + 10Gb Ethernet\n"
                            + "🎙 *Audio:* 3.5mm pro audio jack\n"
                            + "🎬 *Foydalanish:* Video montaj, 3D grafika, musiqa produksiyasi\n"
                            + "🌈 *Rang:* Silver\n"
                            + "📦 *O'lcham:* 197×197×95 mm\n"
                            + "⚖️ *Og'irlik:* 2.7 kg"
            },
            {
                    "mac_pro_tower",
                    "Mac Pro M2 Ultra Tower",
                    "6 999$",
                    "https://thumbs.dreamstime.com/b/apple-mac-pro-professional-desktop-computer-june-cupertino-california-system-aluminum-tower-stainless-steel-frame-high-185202776.jpg",
                    "💎 *Chip:* Apple M2 Ultra (24-yadro CPU, 76-yadro GPU) — absolute top\n"
                            + "🧠 *RAM:* 192GB Unified Memory — rekord!\n"
                            + "💾 *SSD:* 1TB / 2TB / 4TB / 8TB\n"
                            + "🖥 *Displey:* 6 ta 4K / 3 ta 6K Pro Display XDR\n"
                            + "🔌 *Portlar:* 6x Thunderbolt 4 + 6x USB-A + 2x HDMI 2.1 + 2x 10Gb Ethernet\n"
                            + "🎛 *Kengaytma:* MPX Module + 6x PCIe slotlar\n"
                            + "🎙 *Audio:* Professional studio audio jack\n"
                            + "🌐 *Tarmoq:* Wi-Fi 6E + Bluetooth 5.3\n"
                            + "🌈 *Rang:* Silver (tower va rack versiyalari)\n"
                            + "📦 *O'lcham:* 533×218×476 mm\n"
                            + "⚖️ *Og'irlik:* 17.7 kg | Industrial pro ish stantsiyasi"
            }
    };

    // ════════════════════════════════════════════════════════════════
    //  FILIALLAR — 8 ta
    // ════════════════════════════════════════════════════════════════
    private static final String[] FILIALS = {
            "🏢 Toshkent — Oybek ko'chasi 34",
            "🏢 Toshkent — Chilonzor 9-kvartal",
            "🏢 Toshkent — Yunusobod savdo markazi",
            "🏢 Samarqand — Registon ko'chasi 12",
            "🏢 Buxoro — Mustaqillik xiyoboni 5",
            "🏢 Andijon — 2-mikrorayon",
            "🏢 Namangan — Navoi ko'chasi 18",
            "🏢 Farg'ona — Do'stlik ko'chasi 7"
    };

    // ════════════════════════════════════════════════════════════════
    //  STATE MAPS
    // ════════════════════════════════════════════════════════════════
    private final Map<String, String>  productNames  = new HashMap<>();
    private final Map<String, String>  productPrices = new HashMap<>();
    private final Map<String, Integer> likes         = new HashMap<>();
    private final Map<String, Integer> dislikes      = new HashMap<>();
    private final Map<Long,   String>  userLang      = new HashMap<>();
    private final Map<Long,   String>  category      = new HashMap<>();
    private final Map<Long,   String>  subCategory   = new HashMap<>();
    private final Map<Long,   String>  step          = new HashMap<>();
    private final Map<Long,   String>  userName      = new HashMap<>();
    private final Map<Long,   String>  userProduct   = new HashMap<>();
    private final Map<Long,   String>  userProductId = new HashMap<>();
    private final Map<Long,   String>  userPhone     = new HashMap<>();
    private final Map<Long,   String>  userFilial    = new HashMap<>();

    private static final Long ADMIN_ID = 6387107992L;

    // ════════════════════════════════════════════════════════════════
    //  KONSTRUKTOR
    // ════════════════════════════════════════════════════════════════
    public Mybot() {
        for (String[] p : PRODUCTS) {
            productNames.put(p[0], p[1]);
            productPrices.put(p[0], p[2]);
        }
    }

    // ════════════════════════════════════════════════════════════════
    //  ASOSIY UPDATE
    // ════════════════════════════════════════════════════════════════
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasCallbackQuery()) {
            handleCallback(update);
        } else if (update.hasMessage()) {
            handleMessage(update);
        }
    }

    // ════════════════════════════════════════════════════════════════
    //  CALLBACK HANDLER
    // ════════════════════════════════════════════════════════════════
    private void handleCallback(Update update) {
        String data   = update.getCallbackQuery().getData();
        Long   chatId = update.getCallbackQuery().getMessage().getChatId();
        String lang   = userLang.getOrDefault(chatId, "uz");

        // ── Til tanlash ─────────────────────────────────────────────
        if (data.equals("uz") || data.equals("ru")) {
            userLang.put(chatId, data);
            sendWithKeyboard(chatId, getWelcomeText(data), getMainMenu(data));
            return;
        }

        // ── Sotib olish tugmasi ──────────────────────────────────────
        if (data.startsWith("buy_")) {
            String pid   = data.replace("buy_", "");
            String name  = productNames.getOrDefault(pid, "Noma'lum");
            String price = productPrices.getOrDefault(pid, "—");

            userProduct.put(chatId, name);
            userProductId.put(chatId, pid);
            step.put(chatId, "ORDER_NAME");

            send(ADMIN_ID,
                    "🔔 *SOTIB OLISH BOSDI*\n"
                            + "━━━━━━━━━━━━━━━━━━━\n"
                            + "🆔 Chat ID: `" + chatId + "`\n"
                            + "📦 Mahsulot: *" + name + "*\n"
                            + "💰 Narxi: *" + price + "*\n"
                            + "⏱ Buyurtma jarayoni boshlandi...\n"
                            + "━━━━━━━━━━━━━━━━━━━");

            if (lang.equals("ru")) {
                sendWithKeyboard(chatId,
                        "🛒 *ОФОРМЛЕНИЕ ЗАКАЗА*\n\n"
                                + "Товар: *" + name + "*\n"
                                + "Цена: *" + price + "*\n\n"
                                + "👤 Введите ваше имя:", getBackKeyboard(lang));
            } else {
                sendWithKeyboard(chatId,
                        "🛒 *BUYURTMA BERISH*\n\n"
                                + "Mahsulot: *" + name + "*\n"
                                + "Narxi: *" + price + "*\n\n"
                                + "👤 Ismingizni kiriting:", getBackKeyboard(lang));
            }
            return;
        }

        // ── Like / Dislike ───────────────────────────────────────────
        if (data.startsWith("like_") || data.startsWith("dislike_")) {
            handleVote(update, data, chatId);
            return;
        }

        // ── Karta ma'lumoti ──────────────────────────────────────────
        if (data.equals("card_info")) {
            if (lang.equals("ru")) {
                send(chatId,
                        "💳 *РЕКВИЗИТЫ ДЛЯ ОПЛАТЫ*\n\n"
                                + "`8600 1234 5678 9012`\n\n"
                                + "👤 Владелец: *Alisherov Ismoil*\n"
                                + "🏦 Банк: *Uzcard*\n\n"
                                + "📌 После оплаты отправьте скриншот:\n"
                                + "📞 @AppleStoreUz\\_Help");
            } else {
                send(chatId,
                        "💳 *TO'LOV REKVIZITLARI*\n\n"
                                + "`8600 1234 5678 9012`\n\n"
                                + "👤 Egasi: *Alisherov Ismoil*\n"
                                + "🏦 Bank: *Uzcard*\n\n"
                                + "📌 To'lovdan keyin skrinshot yuboring:\n"
                                + "📞 @AppleStoreUz\\_Help");
            }
        }
    }

    // ════════════════════════════════════════════════════════════════
    //  MESSAGE HANDLER
    // ════════════════════════════════════════════════════════════════
    private void handleMessage(Update update) {
        Message message = update.getMessage();
        Long    chatId  = message.getChatId();
        String  text    = message.hasText() ? message.getText() : "";
        String  lang    = userLang.getOrDefault(chatId, "uz");

        // ── Orqaga / Bekor qilish ────────────────────────────────────
        boolean isBack = text.equals("🔙 Orqaga")    || text.equals("❌ Bekor qilish")
                || text.equals("⬅️ Qaytish")   || text.equals("🔙 Назад")
                || text.equals("❌ Отмена");
        if (isBack) {
            if (subCategory.containsKey(chatId)) {
                subCategory.remove(chatId);
                clearStep(chatId);
                sendWithKeyboard(chatId,
                        lang.equals("ru") ? "Выберите категорию 👇" : "Kategoriyani tanlang 👇",
                        getAppleMenu(lang));
                return;
            }
            clearStep(chatId);
            category.remove(chatId);
            String menuText = lang.equals("ru") ? "🏠 *Главное меню*" : "🏠 *Asosiy menyu*";
            sendWithKeyboard(chatId, menuText, getMainMenu(lang));
            return;
        }

        // ── Step jarayonlari ─────────────────────────────────────────
        if (step.containsKey(chatId)) {
            handleStep(message, chatId, text, lang);
            return;
        }

        // ── Sub-kategoriya ───────────────────────────────────────────
        if (subCategory.containsKey(chatId)) {
            handleSubCategory(chatId, text, lang);
            return;
        }

        // ── Apple Store ──────────────────────────────────────────────
        if ("apple".equals(category.get(chatId))) {
            handleAppleCategory(chatId, text, lang);
            return;
        }

        // ── Asosiy menu ──────────────────────────────────────────────
        handleMainMenu(chatId, text, message, lang);
    }

    // ════════════════════════════════════════════════════════════════
    //  STEP HANDLER
    // ════════════════════════════════════════════════════════════════
    private void handleStep(Message message, Long chatId, String text, String lang) {
        switch (step.get(chatId)) {

            case "ORDER_NAME": {
                userName.put(chatId, text);
                step.put(chatId, "ORDER_PHONE");
                if (lang.equals("ru")) {
                    sendWithKeyboard(chatId,
                            "📞 Введите ваш номер телефона:\n_(Пример: +998901234567)_",
                            getPhoneKeyboard(lang));
                } else {
                    sendWithKeyboard(chatId,
                            "📞 Telefon raqamingizni kiriting:\n_(Misol: +998901234567)_",
                            getPhoneKeyboard(lang));
                }
                break;
            }

            case "ORDER_PHONE": {
                String phone        = message.hasContact()
                        ? "+" + message.getContact().getPhoneNumber() : text;
                String productName  = userProduct.getOrDefault(chatId, "—");
                String productId    = userProductId.getOrDefault(chatId, "—");
                String productPrice = productPrices.getOrDefault(productId, "—");
                String custName     = userName.getOrDefault(chatId, "—");

                send(ADMIN_ID,
                        "🛒 *YANGI BUYURTMA* 🛒\n"
                                + "━━━━━━━━━━━━━━━━━━━\n"
                                + "👤 Ism: *" + custName + "*\n"
                                + "📞 Tel: *" + phone + "*\n"
                                + "📦 Mahsulot: *" + productName + "*\n"
                                + "💰 Narxi: *" + productPrice + "*\n"
                                + "🆔 Chat ID: `" + chatId + "`\n"
                                + "━━━━━━━━━━━━━━━━━━━\n"
                                + "⚡️ Tez bog'laning!");

                if (lang.equals("ru")) {
                    sendWithKeyboard(chatId,
                            "✅ *ЗАКАЗ ПРИНЯТ!*\n\n"
                                    + "📦 Товар: *" + productName + "*\n"
                                    + "💰 Цена: *" + productPrice + "*\n\n"
                                    + "📞 Скоро с вами свяжется наш менеджер.\n"
                                    + "🕐 Время работы: 09:00 – 21:00",
                            getMainMenu(lang));
                } else {
                    sendWithKeyboard(chatId,
                            "✅ *BUYURTMANGIZ QABUL QILINDI!*\n\n"
                                    + "📦 Mahsulot: *" + productName + "*\n"
                                    + "💰 Narxi: *" + productPrice + "*\n\n"
                                    + "📞 Tez orada menejerimiz siz bilan bog'lanadi.\n"
                                    + "🕐 Ish vaqti: 09:00 – 21:00",
                            getMainMenu(lang));
                }
                clearStep(chatId);
                subCategory.remove(chatId);
                break;
            }

            case "CONTACT": {
                send(ADMIN_ID,
                        "📩 *YANGI XABAR*\n"
                                + "━━━━━━━━━━━━━━━━━━━\n"
                                + "🆔 Chat ID: `" + chatId + "`\n"
                                + "🌐 Til: " + lang + "\n"
                                + "💬 Xabar: " + text
                                + "\n━━━━━━━━━━━━━━━━━━━");
                if (lang.equals("ru")) {
                    sendWithKeyboard(chatId,
                            "✅ *Ваше сообщение отправлено!*\n\nАдмин скоро ответит. 🙏",
                            getMainMenu(lang));
                } else {
                    sendWithKeyboard(chatId,
                            "✅ *Xabaringiz yuborildi!*\n\nAdmin tez orada javob beradi. 🙏",
                            getMainMenu(lang));
                }
                clearStep(chatId);
                break;
            }

            case "FEEDBACK_PHONE": {
                String fbPhone = message.hasContact()
                        ? "+" + message.getContact().getPhoneNumber() : text;
                userPhone.put(chatId, fbPhone);
                step.put(chatId, "FEEDBACK_FILIAL");
                if (lang.equals("ru")) {
                    sendWithKeyboard(chatId, "🏢 Выберите магазин:", getFilialKeyboard());
                } else {
                    sendWithKeyboard(chatId, "🏢 Do'konni tanlang:", getFilialKeyboard());
                }
                break;
            }

            case "FEEDBACK_FILIAL": {
                userFilial.put(chatId, text);
                step.put(chatId, "FEEDBACK_TEXT");
                if (lang.equals("ru")) {
                    sendWithKeyboard(chatId,
                            "📝 Напишите ваш отзыв:\n_(О сервисе, товаре, доставке)_",
                            getBackKeyboard(lang));
                } else {
                    sendWithKeyboard(chatId,
                            "📝 Fikringizni yozing:\n_(Xizmat, mahsulot, yetkazib berish haqida)_",
                            getBackKeyboard(lang));
                }
                break;
            }

            case "FEEDBACK_TEXT": {
                send(ADMIN_ID,
                        "⭐️ *YANGI FIKR-MULOHAZA*\n"
                                + "━━━━━━━━━━━━━━━━━━━\n"
                                + "📞 Tel: *" + userPhone.getOrDefault(chatId, "—") + "*\n"
                                + "🏢 Do'kon: *" + userFilial.getOrDefault(chatId, "—") + "*\n"
                                + "💬 Fikr: " + text + "\n"
                                + "🆔 Chat ID: `" + chatId + "`\n"
                                + "🌐 Til: " + lang
                                + "\n━━━━━━━━━━━━━━━━━━━");
                if (lang.equals("ru")) {
                    sendWithKeyboard(chatId,
                            "✅ *Спасибо за ваш отзыв!* 🙏\n\nВы помогаете нам становиться лучше!",
                            getMainMenu(lang));
                } else {
                    sendWithKeyboard(chatId,
                            "✅ *Rahmat! Fikringiz qabul qilindi.* 🙏\n\nSiz bizni yaxshilashga yordam berasiz!",
                            getMainMenu(lang));
                }
                clearStep(chatId);
                break;
            }
        }
    }

    // ════════════════════════════════════════════════════════════════
    //  APPLE STORE KATEGORIYA
    // ════════════════════════════════════════════════════════════════
    private void handleAppleCategory(Long chatId, String text, String lang) {
        switch (text) {
            case "📱 iPhone":
                subCategory.put(chatId, "iphone");
                sendWithKeyboard(chatId,
                        lang.equals("ru") ? "📱 Выберите iPhone модель 👇" : "📱 iPhone modelini tanlang 👇",
                        getIphoneMenu(lang));
                break;
            case "💻 MacBook":
                subCategory.put(chatId, "macbook");
                sendWithKeyboard(chatId,
                        lang.equals("ru") ? "💻 Выберите MacBook модель 👇" : "💻 MacBook modelini tanlang 👇",
                        getMacbookMenu(lang));
                break;
            case "⌚️ Apple Watch":
                subCategory.put(chatId, "watch");
                sendWithKeyboard(chatId,
                        lang.equals("ru") ? "⌚️ Выберите Apple Watch модель 👇" : "⌚️ Apple Watch modelini tanlang 👇",
                        getWatchMenu(lang));
                break;
            case "🎧 AirPods":
                subCategory.put(chatId, "airpods");
                sendWithKeyboard(chatId,
                        lang.equals("ru") ? "🎧 Выберите AirPods модель 👇" : "🎧 AirPods modelini tanlang 👇",
                        getAirpodsMenu(lang));
                break;
            case "📱 iPad":
                subCategory.put(chatId, "ipad");
                sendWithKeyboard(chatId,
                        lang.equals("ru") ? "📱 Выберите iPad модель 👇" : "📱 iPad modelini tanlang 👇",
                        getIpadMenu(lang));
                break;
            case "🔊 HomePod":
                subCategory.put(chatId, "homepod");
                sendWithKeyboard(chatId,
                        lang.equals("ru") ? "🔊 Выберите HomePod модель 👇" : "🔊 HomePod modelini tanlang 👇",
                        getHomepodMenu(lang));
                break;
            case "🥽 Vision Pro":
                subCategory.put(chatId, "vision");
                sendWithKeyboard(chatId,
                        lang.equals("ru") ? "🥽 Выберите Vision Pro модель 👇" : "🥽 Vision Pro modelini tanlang 👇",
                        getVisionMenu(lang));
                break;
            case "🖥 Mac mini":
                subCategory.put(chatId, "mac");
                sendWithKeyboard(chatId,
                        lang.equals("ru") ? "🖥 Выберите Mac модель 👇" : "🖥 Mac modelini tanlang 👇",
                        getMacMenu(lang));
                break;
            default:
                sendWithKeyboard(chatId,
                        lang.equals("ru") ? "Выберите категорию 👇" : "Kategoriyani tanlang 👇",
                        getAppleMenu(lang));
        }
    }

    // ════════════════════════════════════════════════════════════════
    //  SUB-KATEGORIYA
    // ════════════════════════════════════════════════════════════════
    private void handleSubCategory(Long chatId, String text, String lang) {
        if (text.equals("📱 iPhone 14"))            { sendProduct(chatId, getProduct("iphone14")); return; }
        if (text.equals("📱 iPhone 15"))            { sendProduct(chatId, getProduct("iphone15")); return; }
        if (text.equals("📱 iPhone 15 Pro Max"))    { sendProduct(chatId, getProduct("iphone15promax")); return; }
        if (text.equals("📱 iPhone 16"))            { sendProduct(chatId, getProduct("iphone16")); return; }

        if (text.equals("💻 MacBook Air M2"))       { sendProduct(chatId, getProduct("macbook_air_m2")); return; }
        if (text.equals("💻 MacBook Pro M3 14\""))  { sendProduct(chatId, getProduct("macbook")); return; }
        if (text.equals("💻 MacBook Pro M3 16\""))  { sendProduct(chatId, getProduct("macbook_pro_m3_16")); return; }
        if (text.equals("💻 MacBook Air M3"))       { sendProduct(chatId, getProduct("macbook_air_m3")); return; }

        if (text.equals("⌚️ Watch Series 8"))       { sendProduct(chatId, getProduct("watch_s8")); return; }
        if (text.equals("⌚️ Watch Series 9"))       { sendProduct(chatId, getProduct("watch")); return; }
        if (text.equals("⌚️ Watch Ultra 2"))        { sendProduct(chatId, getProduct("watch_ultra2")); return; }
        if (text.equals("⌚️ Watch SE 2"))           { sendProduct(chatId, getProduct("watch_se2")); return; }

        if (text.equals("🎧 AirPods 3"))            { sendProduct(chatId, getProduct("airpods3")); return; }
        if (text.equals("🎧 AirPods Pro 2"))        { sendProduct(chatId, getProduct("airpods")); return; }
        if (text.equals("🎧 AirPods Max"))          { sendProduct(chatId, getProduct("airpods_max")); return; }
        if (text.equals("🎧 AirPods Pro 2 USB-C"))  { sendProduct(chatId, getProduct("airpods_pro2_usbc")); return; }

        if (text.equals("📱 iPad mini 6"))          { sendProduct(chatId, getProduct("ipad_mini6")); return; }
        if (text.equals("📱 iPad Air M1"))          { sendProduct(chatId, getProduct("ipad_air_m1")); return; }
        if (text.equals("📱 iPad Pro M2"))          { sendProduct(chatId, getProduct("ipad")); return; }
        if (text.equals("📱 iPad Pro M4"))          { sendProduct(chatId, getProduct("ipad_pro_m4")); return; }

        if (text.equals("🔊 HomePod mini"))         { sendProduct(chatId, getProduct("homepod_mini")); return; }
        if (text.equals("🔊 HomePod 2"))            { sendProduct(chatId, getProduct("homepod2")); return; }
        if (text.equals("🔊 HomePod mini Orange"))  { sendProduct(chatId, getProduct("homepod_mini_orange")); return; }
        if (text.equals("🔊 HomePod mini Blue"))    { sendProduct(chatId, getProduct("homepod_mini_blue")); return; }

        if (text.equals("🥽 Vision Pro 256GB"))     { sendProduct(chatId, getProduct("vision_256")); return; }
        if (text.equals("🥽 Vision Pro 512GB"))     { sendProduct(chatId, getProduct("vision")); return; }
        if (text.equals("🥽 Vision Pro 1TB"))       { sendProduct(chatId, getProduct("vision_1tb")); return; }
        if (text.equals("🥽 Vision Pro Dev Kit"))   { sendProduct(chatId, getProduct("vision_dev")); return; }

        if (text.equals("🖥 Mac mini M2"))          { sendProduct(chatId, getProduct("mac_mini")); return; }
        if (text.equals("🖥 Mac mini M2 Pro"))      { sendProduct(chatId, getProduct("mac_mini_m2pro")); return; }
        if (text.equals("🖥 Mac Studio M2"))        { sendProduct(chatId, getProduct("mac_studio_m2")); return; }
        if (text.equals("🖥 Mac Pro Tower"))        { sendProduct(chatId, getProduct("mac_pro_tower")); return; }

        String sub = subCategory.getOrDefault(chatId, "");
        sendWithKeyboard(chatId,
                lang.equals("ru") ? "Выберите модель 👇" : "Modelni tanlang 👇",
                getSubMenuByKey(sub, lang));
    }

    // ════════════════════════════════════════════════════════════════
    //  ASOSIY MENU HANDLER
    // ════════════════════════════════════════════════════════════════
    private void handleMainMenu(Long chatId, String text, Message message, String lang) {
        boolean isRu = lang.equals("ru");

        if (text.equals("/start")) {
            sendStart(chatId);
            return;
        }

        if (text.equals("🛒 Apple Store")) {
            category.put(chatId, "apple");
            subCategory.remove(chatId);
            sendWithKeyboard(chatId,
                    isRu
                            ? "✨ *APPLE PREMIUM CATALOG*\n\n🍎 Все товары *100% Original*\n🛡 *1 год гарантии*\n🚚 Бесплатная доставка по Ташкенту\n\nВыберите категорию 👇"
                            : "✨ *APPLE PREMIUM CATALOG*\n\n🍎 Barcha mahsulotlar *100% Original*\n🛡 *1 yil rasmiy kafolat*\n🚚 Toshkentda *bepul yetkazib berish*\n\nKategoriyani tanlang 👇",
                    getAppleMenu(lang));
            return;
        }

        if (text.equals("💰 Narxlar") || text.equals("💰 Цены")) {
            send(chatId, isRu
                    ? "💰 *ПРАЙС-ЛИСТ*\n\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "📱 iPhone 14 — *799$*\n"
                      + "📱 iPhone 15 — *999$*\n"
                      + "📱 iPhone 15 Pro Max — *1 200$*\n"
                      + "📱 iPhone 16 — *1 099$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "💻 MacBook Air M2 — *1 099$*\n"
                      + "💻 MacBook Pro M3 14\" — *1 800$*\n"
                      + "💻 MacBook Pro M3 16\" — *2 499$*\n"
                      + "💻 MacBook Air M3 — *1 299$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "⌚️ Watch SE 2 — *249$*\n"
                      + "⌚️ Watch Series 8 — *399$*\n"
                      + "⌚️ Watch Series 9 — *500$*\n"
                      + "⌚️ Watch Ultra 2 — *799$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "🎧 AirPods 3 — *179$*\n"
                      + "🎧 AirPods Pro 2 — *279$–300$*\n"
                      + "🎧 AirPods Max — *549$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "📱 iPad mini 6 — *499$*\n"
                      + "📱 iPad Air M1 — *749$*\n"
                      + "📱 iPad Pro M2 — *999$*\n"
                      + "📱 iPad Pro M4 — *1 299$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "🔊 HomePod mini — *99$*\n"
                      + "🔊 HomePod 2 — *299$*\n"
                      + "🥽 Vision Pro — *3 499$–3 899$*\n"
                      + "🖥 Mac mini M2 — *599$*\n"
                      + "🖥 Mac Studio — *1 999$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "💳 Рассрочка 0% — 12 месяцев!\n"
                      + "📞 Детали: @AppleStoreUz\\_Help"
                    : "💰 *NARXLAR RO'YXATI*\n\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "📱 iPhone 14 — *799$*\n"
                      + "📱 iPhone 15 — *999$*\n"
                      + "📱 iPhone 15 Pro Max — *1 200$*\n"
                      + "📱 iPhone 16 — *1 099$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "💻 MacBook Air M2 — *1 099$*\n"
                      + "💻 MacBook Pro M3 14\" — *1 800$*\n"
                      + "💻 MacBook Pro M3 16\" — *2 499$*\n"
                      + "💻 MacBook Air M3 — *1 299$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "⌚️ Watch SE 2 — *249$*\n"
                      + "⌚️ Watch Series 8 — *399$*\n"
                      + "⌚️ Watch Series 9 — *500$*\n"
                      + "⌚️ Watch Ultra 2 — *799$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "🎧 AirPods 3 — *179$*\n"
                      + "🎧 AirPods Pro 2 — *279$–300$*\n"
                      + "🎧 AirPods Max — *549$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "📱 iPad mini 6 — *499$*\n"
                      + "📱 iPad Air M1 — *749$*\n"
                      + "📱 iPad Pro M2 — *999$*\n"
                      + "📱 iPad Pro M4 — *1 299$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "🔊 HomePod mini — *99$*\n"
                      + "🔊 HomePod 2 — *299$*\n"
                      + "🥽 Vision Pro — *3 499$–3 899$*\n"
                      + "🖥 Mac mini M2 — *599$*\n"
                      + "🖥 Mac Studio — *1 999$*\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "💳 Bo'lib to'lash 0% — 12 oy!\n"
                      + "📞 Batafsil: @AppleStoreUz\\_Help");
            return;
        }

        if (text.equals("☎️ Bog'lanish") || text.equals("☎️ Связаться")) {
            step.put(chatId, "CONTACT");
            sendWithKeyboard(chatId,
                    isRu
                            ? "☎️ *СВЯЗЬ С НАМИ*\n\n📞 +998 (71) 202-02-12\n📱 @AppleStoreUz\\_Help\n\nИли напишите ваш вопрос 👇"
                            : "☎️ *BIZ BILAN BOG'LANISH*\n\n📞 +998 (71) 202-02-12\n📱 @AppleStoreUz\\_Help\n\nYoki savolingizni yozing 👇",
                    getBackKeyboard(lang));
            return;
        }

        if (text.equals("💳 To'lov") || text.equals("💳 Оплата")) {
            SendMessage payMsg = new SendMessage();
            payMsg.setChatId(chatId.toString());
            payMsg.setParseMode("Markdown");
            payMsg.setText(isRu
                    ? "💳 *СПОСОБЫ ОПЛАТЫ*\n\n"
                      + "💵 *Наличные* — при получении\n"
                      + "📲 *Click / Payme* — онлайн\n"
                      + "🏦 *Банковская карта* — предоплата\n"
                      + "💳 *Рассрочка* — 0% на 12 месяцев\n\n"
                      + "Нажмите для получения номера карты 👇"
                    : "💳 *TO'LOV USULLARI*\n\n"
                      + "💵 *Naqd pul* — yetkazib berilganda\n"
                      + "📲 *Click / Payme* — onlayn\n"
                      + "🏦 *Bank kartasi* — oldindan to'lov\n"
                      + "💳 *Bo'lib to'lash* — 0% 12 oygacha\n\n"
                      + "Karta raqamini olish uchun bosing 👇");
            InlineKeyboardMarkup payMk = new InlineKeyboardMarkup();
            payMk.setKeyboard(List.of(List.of(
                    createInlineBtn(isRu ? "💳 Получить номер карты" : "💳 Karta raqamini olish", "card_info")
            )));
            payMsg.setReplyMarkup(payMk);
            executeSafe(payMsg);
            return;
        }

        if (text.equals("🚚 Yetkazib berish") || text.equals("🚚 Доставка")) {
            send(chatId, isRu
                    ? "🚚 *ДОСТАВКА*\n\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "📍 *ТАШКЕНТ*\n"
                      + "⚡️ 2–4 часа | 🆓 Бесплатно\n"
                      + "🚗 Курьер до двери | 🕐 09:00–21:00\n\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "🇺🇿 *РЕГИОНЫ*\n"
                      + "🚀 24–48 часов | 📦 Почта/курьер\n"
                      + "🔍 Трекинг-код\n\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "🛡 *ГАРАНТИЯ*\n"
                      + "🔄 Замена в течение 24 часов\n"
                      + "✅ 1 год официальной гарантии\n\n"
                      + "📞 +998 (71) 202-02-12"
                    : "🚚 *YETKAZIB BERISH*\n\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "📍 *TOSHKENT*\n"
                      + "⚡️ 2–4 soat | 🆓 Bepul\n"
                      + "🚗 Eshigingizgacha | 🕐 09:00–21:00\n\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "🇺🇿 *VILOYATLAR*\n"
                      + "🚀 24–48 soat | 📦 Pochta/kuryer\n"
                      + "🔍 Tracking kod beriladi\n\n"
                      + "━━━━━━━━━━━━━━━━━━━\n"
                      + "🛡 *KAFOLAT*\n"
                      + "🔄 24 soat ichida almashtirish\n"
                      + "✅ 1 yil rasmiy kafolat\n\n"
                      + "📞 +998 (71) 202-02-12");
            return;
        }

        if (text.equals("📍 Manzillar") || text.equals("📍 Адреса")) {
            StringBuilder sb = new StringBuilder();
            sb.append(isRu ? "📍 *НАШИ МАГАЗИНЫ*\n\n" : "📍 *BIZNING DO'KONLARIMIZ*\n\n");
            sb.append("━━━━━━━━━━━━━━━━━━━\n");
            for (String f : FILIALS) { sb.append(f).append("\n"); }
            sb.append("━━━━━━━━━━━━━━━━━━━\n");
            sb.append(isRu
                    ? "🕐 Пн–Вс: 09:00 – 21:00\n📞 +998 (71) 202-02-12"
                    : "🕐 Du–Ya: 09:00 – 21:00\n📞 +998 (71) 202-02-12");
            send(chatId, sb.toString());
            return;
        }

        if (text.equals("📊 Natijalar") || text.equals("📊 Достижения")) {
            send(chatId, isRu
                    ? "📊 *НАШИ ДОСТИЖЕНИЯ*\n\n"
                      + "🏆 *500 000+* довольных клиентов\n"
                      + "✅ *100%* оригинальные товары\n"
                      + "🛡 *1 год* официальной гарантии\n"
                      + "🚀 *2–4 часа* доставка по Ташкенту\n"
                      + "⭐️ *4.9 / 5* рейтинг клиентов\n"
                      + "🏢 *8 магазинов* по Узбекистану\n"
                      + "📅 На рынке с *2018 года*\n"
                      + "🤝 Официальный партнёр *Apple*\n\n"
                      + "Рады служить вам! 🍎"
                    : "📊 *BIZNING NATIJALARIMIZ*\n\n"
                      + "🏆 *500 000+* mamnun mijoz\n"
                      + "✅ *100%* original mahsulotlar\n"
                      + "🛡 *1 yil* rasmiy kafolat\n"
                      + "🚀 *2–4 soat* Toshkentda yetkazib berish\n"
                      + "⭐️ *4.9 / 5* mijozlar bahosi\n"
                      + "🏢 *8 ta filial* O'zbekiston bo'ylab\n"
                      + "📅 *2018 yildan* beri bozorda\n"
                      + "🤝 *Apple* rasmiy hamkori\n\n"
                      + "Sizga xizmat qilishga tayyormiz! 🍎");
            return;
        }

        if (text.equals("📝 Fikr-mulohaza") || text.equals("📝 Отзывы")) {
            step.put(chatId, "FEEDBACK_PHONE");
            sendWithKeyboard(chatId,
                    isRu
                            ? "📝 *ОСТАВИТЬ ОТЗЫВ*\n\nВаше мнение очень важно!\n\n📲 Отправьте номер телефона:"
                            : "📝 *FIKR-MULOHAZA*\n\nFikringiz biz uchun juda muhim!\n\n📲 Telefon raqamingizni yuboring:",
                    getPhoneKeyboard(lang));
            return;
        }

        if (text.equals("🌐 Ijtimoiy tarmoqlar") || text.equals("🌐 Соцсети")) {
            send(chatId, isRu
                    ? "🌐 *МЫ В СОЦСЕТЯХ*\n\n"
                      + "📸 Instagram: @AppleStoreUz\n"
                      + "📢 Telegram: @AppleChannel\n"
                      + "💬 Поддержка: @AppleStoreUz\\_Help\n"
                      + "🎥 YouTube: Apple Store Uz\n\n"
                      + "Подписывайтесь! 🔔"
                    : "🌐 *IJTIMOIY TARMOQLAR*\n\n"
                      + "📸 Instagram: @AppleStoreUz\n"
                      + "📢 Telegram: @AppleChannel\n"
                      + "💬 Yordam: @AppleStoreUz\\_Help\n"
                      + "🎥 YouTube: Apple Store Uz\n\n"
                      + "Kuzating! 🔔");
            return;
        }

        if (text.equals("🌍 Til") || text.equals("🌍 Язык")) {
            sendStart(chatId);
            return;
        }

        if (!text.startsWith("/")) {
            sendWithKeyboard(chatId,
                    isRu ? "Используйте кнопки меню 👇" : "Menyu tugmalaridan foydalaning 👇",
                    getMainMenu(lang));
        }
    }

    // ════════════════════════════════════════════════════════════════
    //  LIKE / DISLIKE — TO'LIQ MA'LUMOTLAR SAQLANADI
    // ════════════════════════════════════════════════════════════════
    private void handleVote(Update update, String data, Long chatId) {
        String id = data.replace("like_", "").replace("dislike_", "");

        if (data.startsWith("like_"))
            likes.put(id, likes.getOrDefault(id, 0) + 1);
        else
            dislikes.put(id, dislikes.getOrDefault(id, 0) + 1);

        int like    = likes.getOrDefault(id, 0);
        int dislike = dislikes.getOrDefault(id, 0);

        String name  = productNames.getOrDefault(id, "Mahsulot");
        String price = productPrices.getOrDefault(id, "—");
        String lang  = userLang.getOrDefault(chatId, "uz");
        boolean isRu = lang.equals("ru");

        // Mahsulotning to'liq tavsifini olamiz
        String[] product = getProduct(id);
        String desc = (product != null) ? product[4] : "";

        send(ADMIN_ID,
                "👍👎 *BAHO BERILDI*\n"
                        + "📦 Mahsulot: *" + name + "*\n"
                        + "🆔 Chat ID: `" + chatId + "`\n"
                        + "👍 " + like + "   |   👎 " + dislike);

        // Caption ni to'liq mahsulot ma'lumotlari bilan yangilash
        String newCaption =
                "🍎 *APPLE STORE*\n\n"
                        + "✨ *" + name + "*\n\n"
                        + desc + "\n\n"
                        + "━━━━━━━━━━━━━━━━━━━\n"
                        + (isRu ? "💰 Цена: *" : "💰 Narxi: *") + price + "*\n"
                        + (isRu ? "🛡 Гарантия: *1 год*\n" : "🛡 Kafolat: *1 yil*\n")
                        + (isRu ? "🚚 Доставка: *Бесплатно*\n" : "🚚 Yetkazib berish: *Bepul*\n")
                        + "━━━━━━━━━━━━━━━━━━━\n\n"
                        + "👍 " + like + "   |   👎 " + dislike;

        // Caption 1024 belgidan oshsa qisqartirish
        if (newCaption.length() > 1024) {
            newCaption = newCaption.substring(0, 1020) + "...";
        }

        EditMessageCaption edit = new EditMessageCaption();
        edit.setChatId(chatId.toString());
        edit.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
        edit.setParseMode("Markdown");
        edit.setCaption(newCaption);

        InlineKeyboardMarkup mk = new InlineKeyboardMarkup();
        mk.setKeyboard(List.of(
                List.of(
                        createInlineBtn("👍 " + like,    "like_"    + id),
                        createInlineBtn("👎 " + dislike, "dislike_" + id)
                ),
                List.of(createInlineBtn(isRu ? "🛒 Купить" : "🛒 Sotib olish", "buy_" + id))
        ));
        edit.setReplyMarkup(mk);
        executeSafe(edit);
    }

    // ════════════════════════════════════════════════════════════════
    //  MAHSULOT YUBORISH — TO'LIQ SPETSIFIKATSIYA BILAN
    // ════════════════════════════════════════════════════════════════
    private void sendProduct(Long chatId, String[] p) {
        if (p == null) return;
        String id     = p[0];
        String name   = p[1];
        String price  = p[2];
        String imgUrl = p[3];
        String desc   = p[4];
        String lang   = userLang.getOrDefault(chatId, "uz");
        boolean isRu  = lang.equals("ru");

        int like    = likes.getOrDefault(id, 0);
        int dislike = dislikes.getOrDefault(id, 0);

        String caption =
                "🍎 *APPLE STORE*\n\n"
                        + "✨ *" + name + "*\n\n"
                        + desc + "\n\n"
                        + "━━━━━━━━━━━━━━━━━━━\n"
                        + (isRu ? "💰 Цена: *" : "💰 Narxi: *") + price + "*\n"
                        + (isRu ? "🛡 Гарантия: *1 год*\n" : "🛡 Kafolat: *1 yil*\n")
                        + (isRu ? "🚚 Доставка: *Бесплатно*\n" : "🚚 Yetkazib berish: *Bepul*\n")
                        + "━━━━━━━━━━━━━━━━━━━\n\n"
                        + "👍 " + like + "   |   👎 " + dislike;

        // Telegram caption limiti: 1024 belgi
        if (caption.length() > 1024) {
            caption = caption.substring(0, 1020) + "...";
        }

        InlineKeyboardMarkup mk = new InlineKeyboardMarkup();
        mk.setKeyboard(List.of(
                List.of(
                        createInlineBtn("👍 " + like,    "like_"    + id),
                        createInlineBtn("👎 " + dislike, "dislike_" + id)
                ),
                List.of(createInlineBtn(isRu ? "🛒 Купить" : "🛒 Sotib olish", "buy_" + id))
        ));

        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatId.toString());
        photo.setParseMode("Markdown");
        photo.setCaption(caption);
        photo.setReplyMarkup(mk);
        photo.setPhoto(new InputFile(imgUrl));

        try {
            execute(photo);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            // Rasm yuklanmasa text bilan yuborish
            sendWithKeyboard(chatId, caption, getSubMenuByKey(subCategory.getOrDefault(chatId, ""), lang));
        }
    }

    // ════════════════════════════════════════════════════════════════
    //  HELPER: PRODUCTS dan id bo'yicha olish
    // ════════════════════════════════════════════════════════════════
    private String[] getProduct(String id) {
        for (String[] p : PRODUCTS) {
            if (p[0].equals(id)) return p;
        }
        return null;
    }

    private ReplyKeyboardMarkup getSubMenuByKey(String key, String lang) {
        switch (key) {
            case "iphone":  return getIphoneMenu(lang);
            case "macbook": return getMacbookMenu(lang);
            case "watch":   return getWatchMenu(lang);
            case "airpods": return getAirpodsMenu(lang);
            case "ipad":    return getIpadMenu(lang);
            case "homepod": return getHomepodMenu(lang);
            case "vision":  return getVisionMenu(lang);
            case "mac":     return getMacMenu(lang);
            default:        return getAppleMenu(lang);
        }
    }

    // ════════════════════════════════════════════════════════════════
    //  START
    // ════════════════════════════════════════════════════════════════
    private void sendStart(Long chatId) {
        SendMessage m = new SendMessage();
        m.setChatId(chatId.toString());
        m.setParseMode("Markdown");
        m.setText(
                "🍎 *Apple Store Bot*\n\n"
                        + "Salom! / Привет!\n\n"
                        + "_Tilni tanlang / Выберите язык:_"
        );
        InlineKeyboardMarkup mk = new InlineKeyboardMarkup();
        mk.setKeyboard(List.of(List.of(
                createInlineBtn("🇺🇿 O'zbekcha", "uz"),
                createInlineBtn("🇷🇺 Русский",   "ru")
        )));
        m.setReplyMarkup(mk);
        executeSafe(m);
    }

    private String getWelcomeText(String lang) {
        if (lang.equals("ru")) {
            return "🍎 *APPLE STORE UZ*\n\n"
                    + "Добро пожаловать! Лучшие товары Apple.\n\n"
                    + "✅ 100% Оригинал\n🛡 1 год гарантии\n"
                    + "🚚 Бесплатная доставка по Ташкенту\n\n"
                    + "Выберите раздел 👇";
        }
        return "🍎 *APPLE STORE UZ*\n\n"
                + "Xush kelibsiz! Eng yaxshi Apple mahsulotlari.\n\n"
                + "✅ 100% Original\n🛡 1 yil kafolat\n"
                + "🚚 Toshkentda bepul yetkazib berish\n\n"
                + "Kerakli bo'limni tanlang 👇";
    }

    // ════════════════════════════════════════════════════════════════
    //  KLAVIATURALAR
    // ════════════════════════════════════════════════════════════════
    private ReplyKeyboardMarkup getMainMenu(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        if (lang.equals("ru")) {
            kb.setKeyboard(List.of(
                    row("🛒 Apple Store"),
                    row("💰 Цены", "📊 Достижения"),
                    row("💳 Оплата", "🚚 Доставка"),
                    row("☎️ Связаться", "📍 Адреса"),
                    row("📝 Отзывы", "🌐 Соцсети"),
                    row("🌍 Язык")
            ));
        } else {
            kb.setKeyboard(List.of(
                    row("🛒 Apple Store"),
                    row("💰 Narxlar", "📊 Natijalar"),
                    row("💳 To'lov", "🚚 Yetkazib berish"),
                    row("☎️ Bog'lanish", "📍 Manzillar"),
                    row("📝 Fikr-mulohaza", "🌐 Ijtimoiy tarmoqlar"),
                    row("🌍 Til")
            ));
        }
        return kb;
    }

    private ReplyKeyboardMarkup getAppleMenu(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        kb.setKeyboard(List.of(
                row("📱 iPhone", "💻 MacBook"),
                row("⌚️ Apple Watch", "🎧 AirPods"),
                row("📱 iPad", "🔊 HomePod"),
                row("🥽 Vision Pro", "🖥 Mac mini"),
                row(lang.equals("ru") ? "🔙 Назад" : "🔙 Orqaga")
        ));
        return kb;
    }

    private ReplyKeyboardMarkup getIphoneMenu(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        kb.setKeyboard(List.of(
                row("📱 iPhone 14", "📱 iPhone 15"),
                row("📱 iPhone 15 Pro Max", "📱 iPhone 16"),
                row(lang.equals("ru") ? "🔙 Назад" : "🔙 Orqaga")
        ));
        return kb;
    }

    private ReplyKeyboardMarkup getMacbookMenu(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        kb.setKeyboard(List.of(
                row("💻 MacBook Air M2", "💻 MacBook Air M3"),
                row("💻 MacBook Pro M3 14\"", "💻 MacBook Pro M3 16\""),
                row(lang.equals("ru") ? "🔙 Назад" : "🔙 Orqaga")
        ));
        return kb;
    }

    private ReplyKeyboardMarkup getWatchMenu(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        kb.setKeyboard(List.of(
                row("⌚️ Watch SE 2", "⌚️ Watch Series 8"),
                row("⌚️ Watch Series 9", "⌚️ Watch Ultra 2"),
                row(lang.equals("ru") ? "🔙 Назад" : "🔙 Orqaga")
        ));
        return kb;
    }

    private ReplyKeyboardMarkup getAirpodsMenu(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        kb.setKeyboard(List.of(
                row("🎧 AirPods 3", "🎧 AirPods Pro 2"),
                row("🎧 AirPods Max", "🎧 AirPods Pro 2 USB-C"),
                row(lang.equals("ru") ? "🔙 Назад" : "🔙 Orqaga")
        ));
        return kb;
    }

    private ReplyKeyboardMarkup getIpadMenu(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        kb.setKeyboard(List.of(
                row("📱 iPad mini 6", "📱 iPad Air M1"),
                row("📱 iPad Pro M2", "📱 iPad Pro M4"),
                row(lang.equals("ru") ? "🔙 Назад" : "🔙 Orqaga")
        ));
        return kb;
    }

    private ReplyKeyboardMarkup getHomepodMenu(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        kb.setKeyboard(List.of(
                row("🔊 HomePod mini", "🔊 HomePod 2"),
                row("🔊 HomePod mini Orange", "🔊 HomePod mini Blue"),
                row(lang.equals("ru") ? "🔙 Назад" : "🔙 Orqaga")
        ));
        return kb;
    }

    private ReplyKeyboardMarkup getVisionMenu(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        kb.setKeyboard(List.of(
                row("🥽 Vision Pro 256GB", "🥽 Vision Pro 512GB"),
                row("🥽 Vision Pro 1TB", "🥽 Vision Pro Dev Kit"),
                row(lang.equals("ru") ? "🔙 Назад" : "🔙 Orqaga")
        ));
        return kb;
    }

    private ReplyKeyboardMarkup getMacMenu(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        kb.setKeyboard(List.of(
                row("🖥 Mac mini M2", "🖥 Mac mini M2 Pro"),
                row("🖥 Mac Studio M2", "🖥 Mac Pro Tower"),
                row(lang.equals("ru") ? "🔙 Назад" : "🔙 Orqaga")
        ));
        return kb;
    }

    private ReplyKeyboardMarkup getFilialKeyboard() {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        List<KeyboardRow> rows = new ArrayList<>();
        for (int i = 0; i < FILIALS.length; i += 2) {
            if (i + 1 < FILIALS.length) rows.add(row(FILIALS[i], FILIALS[i + 1]));
            else rows.add(row(FILIALS[i]));
        }
        rows.add(row("⬅️ Qaytish"));
        kb.setKeyboard(rows);
        return kb;
    }

    private ReplyKeyboardMarkup getPhoneKeyboard(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        KeyboardButton btn = new KeyboardButton(
                lang.equals("ru") ? "📲 Отправить номер" : "📲 Raqamni yuborish");
        btn.setRequestContact(true);
        kb.setKeyboard(List.of(
                new KeyboardRow(List.of(btn)),
                row(lang.equals("ru") ? "❌ Отмена" : "❌ Bekor qilish")
        ));
        return kb;
    }

    private ReplyKeyboardMarkup getBackKeyboard(String lang) {
        ReplyKeyboardMarkup kb = new ReplyKeyboardMarkup();
        kb.setResizeKeyboard(true);
        kb.setKeyboard(List.of(row(lang.equals("ru") ? "🔙 Назад" : "⬅️ Qaytish")));
        return kb;
    }

    // ════════════════════════════════════════════════════════════════
    //  YORDAMCHI METODLAR
    // ════════════════════════════════════════════════════════════════
    private void clearStep(Long chatId) {
        step.remove(chatId);
        userName.remove(chatId);
        userProduct.remove(chatId);
        userProductId.remove(chatId);
        userPhone.remove(chatId);
        userFilial.remove(chatId);
    }

    private void sendWithKeyboard(Long chatId, String text, ReplyKeyboardMarkup kb) {
        SendMessage m = new SendMessage();
        m.setChatId(chatId.toString());
        m.setText(text);
        m.setParseMode("Markdown");
        m.setReplyMarkup(kb);
        executeSafe(m);
    }

    private void send(Long chatId, String text) {
        SendMessage m = new SendMessage();
        m.setChatId(chatId.toString());
        m.setText(text);
        m.setParseMode("Markdown");
        executeSafe(m);
    }

    private void executeSafe(BotApiMethod<?> m) {
        try { execute(m); } catch (TelegramApiException e) { e.printStackTrace(); }
    }

    private KeyboardRow row(String... btns) {
        KeyboardRow r = new KeyboardRow();
        for (String b : btns) r.add(b);
        return r;
    }

    private InlineKeyboardButton createInlineBtn(String text, String data) {
        InlineKeyboardButton b = new InlineKeyboardButton();
        b.setText(text);
        b.setCallbackData(data);
        return b;
    }

    @Override public String getBotUsername() { return "phonesotibollBOT"; }
    @Override public String getBotToken()    { return "8782129671:AAFajKwdOsh0IBSiNfAG1yj4tM77jde-JWs"; }
}