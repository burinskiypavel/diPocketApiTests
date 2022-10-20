package tests.bo.boTicket;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.text.ParseException;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class RejectSelfieChangeTicket_FromMobileTest extends TestBase {
    String cliSessionId = null;
    String phone = app.homePageLoginPhone;
    String pass = app.homePagePass;
    String cookie = null;
    String username = app.BOusername;
    int clientId = app.homePageClientId;
    int ticketId = 0;
    String actualTypeName = null;
    String tomorrow = null;

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException, ParseException {
        tomorrow = app.getTimeStampWithAddSomeAmountOfDays("dd.MM.yyyy HH:mm:ss", 2);
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(phone, pass, HelperBase.prop.getProperty("mobile.login.deviceuuid"));
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_clientProfile_updateSelfie() {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("content-type", "application/json")
                .header("clisessionid", ""+cliSessionId+"")
                .body("{\n" +
                        "  \"base64Selfie1\" : \"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\\nSSEKiX8B/9k=\\n\",\n" +
                        "  \"base64Selfie2\" : \"/9j/4AAQSkZJRgABAQAAAQABAAD/4gIoSUNDX1BST0ZJTEUAAQEAAAIYAAAAAAIQAABtbnRyUkdC\\nIFhZWiAAAAAAAAAAAAAAAABhY3NwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAA9tYAAQAA\\nAADTLQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAlk\\nZXNjAAAA8AAAAHRyWFlaAAABZAAAABRnWFlaAAABeAAAABRiWFlaAAABjAAAABRyVFJDAAABoAAA\\nAChnVFJDAAABoAAAAChiVFJDAAABoAAAACh3dHB0AAAByAAAABRjcHJ0AAAB3AAAADxtbHVjAAAA\\nAAAAAAEAAAAMZW5VUwAAAFgAAAAcAHMAUgBHAEIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFhZWiAA\\nAAAAAABvogAAOPUAAAOQWFlaIAAAAAAAAGKZAAC3hQAAGNpYWVogAAAAAAAAJKAAAA+EAAC2z3Bh\\ncmEAAAAAAAQAAAACZmYAAPKnAAANWQAAE9AAAApbAAAAAAAAAABYWVogAAAAAAAA9tYAAQAAAADT\\nLW1sdWMAAAAAAAAAAQAAAAxlblVTAAAAIAAAABwARwBvAG8AZwBsAGUAIABJAG4AYwAuACAAMgAw\\nADEANv/bAEMADgoLDQsJDg0MDRAPDhEWJBcWFBQWLCAhGiQ0Ljc2My4yMjpBU0Y6PU4+MjJIYklO\\nVlhdXl04RWZtZVpsU1tdWf/bAEMBDxAQFhMWKhcXKlk7MjtZWVlZWVlZWVlZWVlZWVlZWVlZWVlZ\\nWVlZWVlZWVlZWVlZWVlZWVlZWVlZWVlZWVlZWf/AABEIA8AC0AMBIgACEQEDEQH/xAAbAAEBAQEB\\nAQEBAAAAAAAAAAAAAQIDBAUHBv/EAC0QAQACAQQCAgMAAQMEAwAAAAABESExQWGBUXECkQMSoQQi\\nsfATFFLhMkLB/8QAFwEBAQEBAAAAAAAAAAAAAAAAAAECA//EABcRAQEBAQAAAAAAAAAAAAAAAAAB\\nEhH/2gAMAwEAAhEDEQA/AOsFZOlxMMNJcxpLVzJ+sUVSBfCLmEu9gCsF8FgLXBZXgAz4XtARbEBY\\njK+0zsUALRIIWpQIqKqIUpuCbiwApKaFgpaAAAGxaKAAAAAFgAHsAkAKABAUEAACQDYAAAABQ3Cg\\nBFAEldkBAUEFJAAANwAXZACFEkFAAAAF2QAABUWBEF2QFQ5UGYtemc2sfKUaU3W72EEsvgm/CAt8\\nBE0fsCJ1LX7Ql+AOli0sBQuSwXoRewEpZAJAAAABVEFQQRSQAIAoVAAQFLRQBFAAA9gAAAAAAAIA\\nAGwAAAAAGwAKohuqAJKgJBKgIABsEqCCzogKigJAKAG4AqAAAAKIgKKJsu5vqIgpAM42lFpJjllp\\nakjhKm1oGoyfrwxNclVvIN/qlJFzvK5AFAQW+AEoppLArkiMn7T4P2BaEssAAAtF3A1IBRZQBAAA\\ngoAkABFAAANy8ABAAAAIqAKIAoigCbgBIAAAAAAAKgoKCCBsAbAAAKAi6AgqAoAAAAEAQqKAACCg\\ngB6AAASsLIBg6sqJTRlouPBZdStwDKrhASPa3zCJ7gGr5MeSK2ha4BFKSsAvRdpRQKQVRmACggFm\\nKJKNREFpKFCwsAsFRYQACQALAAPYBuIAKigQJ6AAABIUAAFQAAAAAAAAAAABRQBAAEAFUQVAAAAJ\\nA2AAVKUEhYADcNgACgAANzgsAAECQBNDKwRFstHSVC58F8AlHtrF6ExAMk1a1lKALKKAyqUA0bIu\\noASmfAKYP1k/URFsALRQVAURNxaN1CgtLBUNwFQAAAQUBA3UAADdBdAQAA3NQAAA8gAAAAAAAt2i\\n7ACKCbBsAKABuiwomgUAAAAACm4AAAAGxuAAEbAbhuAHkAABACQQgIllouS8W1il/WPAMWsTMrPx\\npKAuScqlALjZEyDRTOfKguYABS2SwbvCJZYGaCyxABQNixFJzqHtBABQFSQFpFFQJBCQAAAAAEUB\\nNxao9ghuAAAAEAAAAAAAAAKbCgiiAAAgoJuKbKCKAigAABsKAmxsKCCoCm6KCAsAioQAAAABST6a\\nKZVlYnkmCgWxmlBrKF5LAvg6S1AtFKBN9TtayUALQDNDVG4JRSnQIAqB6BFBDcFQL8KgBNoCWtCq\\nQAACAoiiAAAEgSkKAgAoUAgC7AIKAACAAQKAAAbgACKCKCgAAAAAAqKAACKAAEAAAgqAKJsAEgGw\\nqAhHyW+LMTsyp+0LcTslJXANYPSXnQsGqIhILBaKLL4AoosBBSgAooEMgAsQWWITBRcntVQABF9C\\nCKUKAaGyAaiKCLMAIKgKB5ACUBQNgAAQAA3yG4AAgCigbAgAAQACKgKQAAAAAAAAAAG6igASbgAB\\nMAAAAAAAAAIoCGwgLZYfrbKmFT9SgUoorkEXK1MpUgqEQtACUAq2zU2A1SEFiCKAgp2CY8Gy0lqo\\noAgWIGgKohQoILCWAlfSgIKiAGgoAABHAACToC7IAgEm4oilAAAsIAKgCKIoAAAEgAAG5sAAAAAK\\nCgCgIqAqAACggGwBuAAICoABsbgLceltn7XZlSJUpNAU6SVsFstLs3BbSwA7K5MlATBVJ2Au5cQm\\n50CzPiDMpZcgohALgrwLUKM9qtJAINJSCAAF5P6AAASigJAAKIKAqIFgKCUqAAoIAAAAAAAB2AAC\\niIpsAAAAbgAoIQFACgFAqgBIAAAQAhSoAKlgaAAEgAgbASADf6e4T9WarSZaifl5hlSqXKftK3IG\\nPCTS2R6BC1qEqAImGrhn9Y8pUaA3ceE6SIgBSuUhQKgqKN9C58AUfqZQFmKQAAkAAAAAQUAOigAA\\nQX0gBPJ/DQEFlAAAAANwFEUAQAAAAADZUAFQBRFEAAAABdjcEUARQAIFBFBQAAAgAAAAE8Hk3QFl\\nFlNgUEAAAABqCUtcMqi9i14BMlzwtFAzeNFWqLjcEoqVwXAJUrnguOFuJBnRbgmvKf6fILMiWWC+\\nDdPYClTZMlggoCIoBQAFBABGpJZYBYAGwgKgAAAigCKiqIABIACKAgFAAAAAAoB6AAAFRQRFRQAA\\nFRQAUEoFUQAAAAAEVAAACUXtAVAAAA2ABqp9n6yV7VlWaVZ5TALEz5KSYNJBSplIWQSp8lT4g9rX\\nIJXC/r6KK2sCo4KhaI0BKFJgGVytFQDI1iNk6BFABJjhclAgtFAiWtAIqoAAAACLQAlCygAigiib\\nqAoCAAAoIACC0AekUAAAhaPQAFgAAgAAoAihAAKom6gCFqgAKAipIJIAHg1kAAAAQAAANkB1qUzE\\nGFxtLKpcbwYWoSfjMZsAkAQz4U23AyltfaUCWXHC1BMAWXR0AWXJkAsufAUBcpa7IC2XKFAt8n7I\\nUC/tKWVhaBLkCgAoAAADBYFb+AUEAwB6RUACwA9goAAAABICCoAUAKJuoAAAICiKBsSACgIBuQAo\\nKAUAAAAbAhsAAAAACEgG6KkgSkl2AAA6WX6ILhlVx/432mOTGyxIFcpSpYJUmfK48rnabBIlbwkx\\nKfr8tgbpKSI+RUgtIuS/QM/Znlq5LkGciylAqFFAXsRK0AQqQAsyl5VABU9gBUFgAAJoqAeiwBAK\\nBUFoEDcAAUNwEABQAAAARRAAoAClAAAFoEU1QFP9hRA3ABUAAFAFBAAQAAEAsCwEVAVABINl2QA2\\nVNgbrghr3EmzKs3Hgwv0nX9BrHkrVLjkvkDo6tbAS58F8Fl8At50Sjo/bgCshE2oBkMgCVJU+QA/\\nXB+oFllAEFFlgtwMrsBaoAAABRuAbCAAAbKgAUAAUAgoolCgIKUAlKAXgEgFAAAQEUURdAAEUApU\\nsFRQQEUAUAEFAABAAAA5RUARQBBQQnQ3NgBAFRQG8eV9SdJhlVzwTHCF1qBktb9nYM/S2tIC7awV\\nKY8/w/01qC5XLNRO6VyDWdi58J2fYNbaCRKA1ZcpAC5lKkssCk/Xlq0BKKWiuQSlMey62ADcuALg\\nL4SwAAClQAACgAEWgAQUCRQQpUAvwKgAFAm6l+ACwAEUAAQAFAUAoACgBBY5EBRAFtAASwUNwAPY\\nAAmwAbiAKgAAAkigCagOtckxJAyqdLPouluK1BnHg/0tJUAmPJ2tZSgO1SiAWuSPjymSprEgv68n\\n6z5TPk7AmJ8lT5FsVKzrJRfBcgVJ2KCUdqCIvSgM5NWpgBmimognAM0RC66HuQKAroEFwAgAAAIo\\nfwBBdwQUURQQCgUEUA0AACigAALQUEUNgAALKFAEUQQJAC0AvIAAABsCgACAAAAmwACKAgKCAA6z\\nRQMqI0UDML2tH6gEFJsB0V7AA1JAM+DPgPsDJUpQKZFqARM+BqUwKha9FT4AssPoQufC/SY8l5AM\\nwfsAVO8lLUpXIAaAIpRcAAAm5ilAQNjIKgAAABQAogKgqiKigFgCC0AgKCCm4AAIKAIoIgEgIKCC\\noAAACSoAABKAAAAAIoCLsaIAADrUot8LbLTMSsT7W+EuAW4nydpjk7kRSbTPkzwBUhZdgUTAX8gD\\nPJk/1CmfCZ8LXy8pXyAz4LnwV8tj9Z8gufEETKfrPkqt4Bb5LsuNy4BOylKESliY9rUAJ0ZWUAoD\\noCzIWBXkxBmSgL8C7F8AgoCG4AhSgCKoIAAGqggFAC6CiC7IAUqACgIKggaKgAAHkAENlQANwBCy\\nAANwAFElFq0ANllIAA9gCKBuAAioAGwDpfJEyUjDS3wftAdqLcWuL3ZXALiT6TtYnkQDHlBVO2aw\\nVYNZ0iUqZ3So8lQDX6z5Sp8pgBa5KjymuDqAJiPK+oS1sCiktQND7RaAox5KgxGwiY5ldtKLgsAM\\nygLgOygLgOwAAAUvIAixACKAmmpaoCnpAAUAT0teQEUAAABUABfQIUCogoCAAAAIoCIqAAAAAJJa\\ngiKAJuoogLsCTqAAbiagCogAKOl8m6DDS0Ul8FqLSLEwuK1BnG61ytcpXAFBRSClFcnaiCiBfoua\\n0hM+EufEA140LrwmfEH0oXPBYXPABXsuVufIFKhgD+nReSwOjIZATRa5KjcRLMysTxC2DNdKZAAM\\ngKgBaoAAAoi9gahZqAC0CBKgigAAAYABFAQCVQBQZX2ACKkgIEgIAAWAJKoAoQCCoAmyyAIuyKBJ\\nIgAgAAACjZ0ow0mClsuAZKlq4OwTKNExyCCzCY4ApalMALRWEui4Ba5Xtmy+YBZoO4LAwWY8qCL0\\nUUonSlAGwWAtoAFclICLcFztBnwdglzesR6X+mAFQIAFoAKk9QmQK5L4WgDJ7C8AQJ6XO4E8qkKA\\nC4gEVCwUQBaT0oCC7AJQqKgigIlqUCAagItJIJRKgqACG4ICoFgASAi6gIqAEgAIoolCgISFg3UL\\njyXGgw0V4kyKozng9xDSAXHgx4k6EFxylQY8kewKjyV6O4OwPowlALUVsVHhAFiIEueToGoL5Z12\\nNwavkuUMqLabnQAtIAqGuy7AFoogC0CC0VAILgsEWsAAB6AoosAKACAmTUCwMApaAKAAqALQAAUe\\ngQUUZUBBF1QCtT0ewERr0gJ6ABAoASZVAJ5A1ASlAKEUBJJAAiQAtNhQAARQHaUIn0Wy0gpQEl8J\\nRU8gWWXJc5QDov0uvgGejLWErIJkytFAnZlaATteyy+AOzsvgvgAv2WQCXwL0t8QogXP/IOwAAFp\\nARf4WiwC58fZ7kAMew0AOwAF+gBP6KAJSgGCQBBQEWA9AUGQBUUEUAAFQNDVAAADYAQWUBBQETRQ\\nERQESmkFSlQEAJkUQUREUACQBFJUELsBAAds1mE9/E21XtlpPsvlc0lAWtpU+ErgFvgtKryAtl8C\\nILZcIoBZUeSo8yAUvZiwQVMcAfRfpf8Amh3/ABRLPsyfYFBsXwAGUBaK5AClRQAMeRBe0sBpEyoB\\nZiFBAUEVFAAACy53BUgOwPYQoICgnYtAAUACoqF5AAwlKAnoVLsALhAElQE2RQEFQDCSqAIqCkoo\\nCbKIIGwaAHkKBNiFoUQJNwEVAdRT3DDSAKHZ2sp2AbakewDs7L9HSC9p3B0dAB0vUAEdJniDPANF\\ncs9wdg1SUmTPlRUKnyVjUCiuDAB0fQXAgdF+/oFURREpTJ2CiAC9CXgF/gAFm+gAtmSZ8ICpoKCW\\nKAEKAAAAAvuS/CAGSg6ACgQAUBLPYFpmVAKOj1H2n9A/oAIBICKgCLSClJ6UBDYBEF0ASdRTcBAU\\nJRQECcJkAAHUDdhouYW+UKBfOYN9krhfsEz4grgiuVx5BK4hGrjygFERYAUVyYMWBUeSogwAVCYU\\nBFLAQyp9glLXoriTPj+qH0uNrTPEHYi//oigBXAAAABIBYUBZCmATKqgLSbgC9iKCiAAAAALuIAo\\ngClgAAIlypYoGgAgey/AGZDICFeVzKAli0V0DIuLQUSVrkBKKWUATdUEAQFRaFEAA0TKgIioBoig\\nOqpfBbDS4QuAAuvJcE0BfMl0dm4FlmVgEstSsgnS5mVgBAAEtSgQWigZz5X7WivQJ9hXmT7UFpAR\\nd9gAPYIC0JYCiLgFEsufAKaSdoCh0AYLC4AtU2AX2IoAAAAAFgokKAIoAgC+kCgNALVAuiwUAED+\\nImQUCQSgAEVBRFAQNC/AgkKUCCpsolKAIioAigIEgOvYisNJXBS5L4BI9i9HQIvQKBjkL9IBEF+g\\nANwFwi/80KAD7PsDPgrwf81PoCig9qFGCigLgvhaK4ETtGgECuZKBBQEpQAKEBRCwW/AAHsFAAyA\\nBfACoUCggKJwoAAG4AFqmQAAAO7KUSywqQAKAwAAegzIhgSeABPa5AT+C+k95BBdQENyIyuyiIuQ\\nElFAQCQRJUmKBDSSZTcHYBhpFQBbLQBb4MJlVCaMFlygEFzZkCslck2ZAx/5UuP/ACTJUgY8mFqS\\np3ETH/IUMKFAWCiWAoKCFAAAAfRQAkr9lAhhTsEopUA/opWATsXFAIqH9BRAFstAFsRQFSa9qBQm\\n6ge5I4gAOxQEAAAULBAAz6MAejSTIAAIH8DAIf1UA1FRRF2VECUUuNlE1RSgRLhZATdMLXQCfxFl\\nAQpUB1C+VthpBUAMF4FAEBezOiYswgufJnyFxyCZ8rfsx5MAlz5U7ASy1+wAyFAZLPparcC50DBi\\nFQypaXwCmABRNlsDpOlATPkXtAFTIAX4KgAyCAuEAAACwpQRf6igX0f0owAsdIAuC+kUE9rZ/sYA\\nKL6AAFAAA9YQAoAAwGfQipZ7ydAe0X2noFEAUQyoTBPAAB6PYJg/5S3UpYCG5sCGqoCUizyWCZ3R\\nT+g3XorgqOTHlhpceDCdmfILgTNbGfAL2FT4SuFFMlT4SpQUSpKBey0oBbEUEUAEUAAAKnUz5O1F\\nQMApElliKJagAdAoXPBrqAGLAKABKFATY9QABuGZAowUgLZsgCgAEAAqWoBeAAJAAsFEyGqgn8Co\\ngAzvIAAABRYIYAAQJ5AsEUUSwFtCwBF9gJITMRylzIGmpaVS9AgeyZBCZpM+loG79hvoVDDQdFRy\\ntR5kEoXsz5ARanyZhQDJsCZF2QAL4LjwgF8lwWAFlgYMFmqigAAABgADuCxCywAuVQBYksAURQFS\\njFAtiTMFgKgAuSIXHkGVo0LAryf0AEAAINNQF6PUAHZ0ej2AUAACgigGiAAFoC9iKBaZXCWC0mCv\\nJoIZkJlAARRQ9lgBKATKZldAEqlnVACUmST+QCZKVAE1AHQieRaYaSJ5XsmBQz5RajwVAGTJMQYA\\nyAAJ0AvR0mTKB0LlMqAvadgGQ7Aytc/1MAHcLjygBhULBehL4UQNjIABkADoUvwuT6L5EIsS4UFw\\nJBtqDRaALaACidrgE3X+JYBjydL7ARQ/oCmfR/QSxUADsqQLDcURcQT7sBM7Hufo/pUgbYS1rkAB\\nAVLwX2Z4gQABMEh0B6JEUNBUn7BS4SbwlwCoFgIAEgnYFxBqTKTmgJSZypOgOlBXAy0KmxkFoQsF\\nyUhuCoHYGQ7OwKnxJnk7kn2BFlT4kx5XAJS7f+zHgvgAr0XwAdhfB0IIv0dgdJ0qAWKn2AC2BuCA\\noAAAKIAtlhjwKFB2Iu4igX0AB0qbqBRUItguC/EJkANVvhKn0C1ylwV2AqBIACiKej3UAaJM3pcm\\nPBMzwBn0YgBDKVG+VtLA2BAVM+QABALAvpQ9k64QkDs9IAu6AAIXQKiXK0CbYAsDoklJB1WipRlo\\nyuRLmwWcJnytz5QAW5S+AVFvOkJ0AABg7M2AWFFAFyHcAXzC9nZ2B9lIohQApQdAiCgIp0AAbgig\\nABYAXIgbKgqrruIvYG5YCAKALwWBUlFl+ZBaLjwlxgupwC3KGSuQAJAMAoIGPIHZnb+nqCdMyB/U\\nvxBce1uegM7zSUIIt5SwmQDCZAWykACxFDfwIAJK2kgAAAlgtJhJkvILZM2zZfkFsmUvVNgWyZTc\\nUejuRL4XpzaBLFFQtbBOjC3hAMBYAFgBgADBYBgx4AC+FLAOjIYEDsAOwwXxIBk6PoAqNhPsF6EO\\nwUwhESC2FeZTCCgABkUFQFWzogoQypsABtooBRvqAUqYAVD3JjYDoJT0oF1uZ8lQBZc+BLkCbncw\\na8lAIACKggAAABQAIqTJn0AiykyoUEygGEsQFSQkEkXdAEUBKkABLPZOFHoL4BzaL4L4AEtb4LQF\\nvgsALAUCAALACwiChBPpaKgDIUQKHQCCpsoAFgBfC3PgEFqUyAeigDJQATAAAAGAAUhFAyqLYC30\\ngClbgBgKAL5BLBTpLAW0sRRU3EsFLQoFtAAEBF9EJfgBUsAPZfZhLiACojezNlcgX4RTIJAH8UEX\\nT/2kgTCCAIoCAXwAIAZRUsDdZZsB6QwYYaCgAoRQAsAmyNOU3LBRLVQ2LRQNC0BFgTcFWy0BFuRD\\nMgpjkrlAW48F+jBgF/YuUOgWxFA6Lk+wDPkAAAAAFE9AC0AAAKuE7McgtxSf002iDILlOwAEFAC8\\ngSgAEABqIAWACdlKgLolqggdC9gioAqYDsCUCpARce0sCj+iKCKmgATogCKgCKAgIATIgPTQvZbD\\nSCn0CCgJ0BWQAooAK8igqfZ0BwUAhRWcAKHZRWBDBgAOpBQS1sOgMgCgXJ7EFQsVTpARTCKB0Cgi\\n0WAUACh2fcgB9HYEl5TBYFglqKgAG4l4BULTUFmS0AWxAADIAF8AAYELDZJkBUlAWwALQ1AJM+BN\\n1AEmQFmkXAILbM+wCZAERUBDckAQAenJlbLYaTJkX2CZF2AQCgLW0oALBQte0K2BZ1INwEFiUBRA\\nAAQ+i5RQAAABVEAWwAA7QFAyIpqigLoICgAqBceQBL4kuQVN9QULg8gAlggIoogXkAkRQEUsA7AA\\nLQFSwEJlFABDcUJkQFtJEkRdECVCwAAtAVNhPcgaAAgAJJMgCCoD1dgMNEiWXxAAXwTPACpZYgaF\\nl4BS/SGAW0swYhVLLLgsCwtAUQQUQBTAKgWApZYtglhZkCig7AqIXCUsaCAAAAChgDJnyKCUuIQs\\nAVFAEQUQAksAQpUtQE8gKIAAAWFgAABIgioFgCAoipIgCAtpZuAewPagUl+DILollFgfxFTABqX4\\nhAJovWgBJE2AesEYaVDHkwAFxRgBFxZYiCmBUBbBCAUF6SyxFrCSWAonQiqdICLYUUAXwApfBkFA\\nAAAALAFRRAADKgAAAABZYgAAAIoAWgCCgACKICoSWAFoDSWgIXwAAuGbLFWy2bkBbLQAsNAQEP8A\\nYCy0mRRbEQFLTdQJ8noAQE3AlFlLAsvCEg9Z0dHTDRrsY8HSbAuPBjwh0IvQgC/R9JR6gFwXCVPg\\nz4ADJkA3PoVQAAsEA6MgBtsFgAKKgAogC7amEiwFvhWVBbEyCKFgKIAoUVQFieSwAAEsAA2FAEBU\\nNjcBFAQLUEoABLXdANhFEQowgAlqB2WSgqyhZuAlm6CLZYkKLqgAAgLtKpYAWhuAipIG6CgGqF4B\\n6y5QYaUQyCiJsI0IAozhcAohgAMCgG2gBnwZVAMioKAIFcFHZQFAKAbgElBYFAAokLAAKIHR6L4A\\nyBgAOgAACULLAEtb4BFQUAQFEUE7OjBkDJngyUAB0CGROgJtKW0kQ7MbJeSQJkEACy5kClTIof7l\\ngiiBeVAEBd0AAQkAlLLBUmdAELBJBUsJ11B7EXymzDQAAGgISACKYMeFELVIAtbm0UAoBQAQWkjQ\\ntFVAAOgA6KngAKnyVybooY82uABLW1KyCLkOgCC1vmgMgXAi9oXwZmdANwz5MewQXHhMgaggKgAH\\nRaKKJksBcMmIBbL4SJ8LfIGUMAKhMpYKkmUASaMXkvwIl8GV+oT3IoGCwNhLLEUZ1UUsCwAFEBdg\\nGV3QBJhZ1S/ACKgBYCF4QALQ3Ae0EllpRBEW4SaBQxRhBBcGEFFwWICiKAEgFrcoAtloXnQVbLlL\\nnwXKCmUuTfUFo7SuSoBceS4SuBRb4LPoAyAAqLQH8MeSuFES/FrnwAGeCvMgBUJ6hbTIHYUTQCBY\\nCKihZMoWBk2JQF/ohkAQsFEOwUuU6JsCuaMebTs6AuPCWqYBJnJvoqXG4BRcbJYLVGE1AXpDYADA\\nIAKBsWb4FBJyAIqAhK7gibAYBCVtnYFLQB7dywZUQADHgOwOkvhexBL4LwChYWWAQCC3wIuwEF8I\\nqheUUFA7LQOhFAL5BQsAANC5BRJtQFtC4BbOkIkRqpTbU6AXFbl+ITsBbn0nYAgphRNEUBBUAyi0\\nkwBhLNwDNoZIjkAMAJsvpM+j3MgBgyBnwk6HZsCXAqAnZS0AhKoAFFcqFpfa1BuImaXsARS0mbBU\\nlJAWJlAFCUssRUsSgAwgEhsgLKSIg92aX6Q3RT6CUBbLEAsvIAWXPBkoULBEAoBDKkgZAUARBTBR\\nUeRRUNwWy0FFDsAAvGgHQZXYEqVqDtQIMgIVAAHS3M7CdgufKdyfSWC48JZrsVyoWkrhLAmDtABB\\nAVLkSwWTZDsFuvCXyhiIBbgT9iwUpMk1vIKl8FxtkviACYEnAKgABR2CC49mdoVEoWeZTHiwCYTj\\nQ1AmvJZU+DsEFSwM0gAYQIAslACJMooAJugJuSgr39Ja9yksi2ZTBgFyWhuBkzjIelDJk7IQM+Uy\\nFAqLuUAAAegArAAACgAKAoIqKBfJuAAZAFtFALMF+xCwAWuZMIWBjaDJkUEwFgdJktAN9T0TNaJY\\nKiWAqCATJZgBBUsFEssDHsuEsBZkTswCiAKAAdd2Ai3Pr0k8zMgoIsgIfSlgkpJmgBCSgTdGqSdQ\\nSkpoBKIUBknRamU+VfH/AOXy+MdoEss/L8344xF/KXL5/wCT8v8A6/GITsakrvESz8vl8IxMxM+I\\neafn8vlH+v5zPZ+3xhNLl9gKygytkTJhNAMmdQBbkygC5M+UzyAonYCiKKCAKBsIAABAoWAgZA2U\\nAALAAsuQAVLImQXYQBez7TSAFvgtOlsC7DsUQLSwWT2lz4MgYTBMFAkyTIkyAmBJkFstCwFT0AqE\\nygKIAWtsqC2mSwF9mPKAKuWT3Ko1ZMs3ReAW+DtnwA1cEyzaTINTJEszKWDUiWm4NDOxeQasZn5V\\nbl8/y1iAdpmIty+X54i6rDzfk/LM3N/TzfL8tROcovHs+X+RPymp+VQ4T+X4XiXg/J+eYireP8v+\\nRMRMR8krUfU+f+VGnx1cfl/k/K9ft8r/AKvzm5i86n7TX+uUyun0f+8+MayR/lfto+f+0RrMQn/c\\nRFVJlNP71DXIMkyWAFotIAqE6gvZhNyAXGTAgLcUbBYoFliEeiiywFyyvYC2huoLugCooBZohYKI\\nWAqWWBYgC+y0AWZWZZssFzyZS+S/IL2tQzfBcyDWC/TOVULSzBYILeyZATY7SgLSy4OgE3JKACgC\\n02ADcLSwUQsCZkkSwUtm86LYNWMGQatbrZkuBFuZ8nTN3qZBdieESQXcSy9gWy8oCrbPymosmXL5\\nyInz+fLh+T56r8vk8/5PlOorP5PyS835Ply38/l28n5Pmqs/k/JEResvL8/zZxEQv5Jlxq9ziLP5\\nflMasT85nV0j8V6ZP0+Ma/KFHLMrEctzP448/KWf+pMaRECP0WBKgw5qpszhQCAgAkJAkAAACwBQ\\n6NjAgAAFgKGRQCgAAALSQUQAAAEwAWqWAAAFiWC2IAvZhAFstLSwUQUCjsmQRUsAoEARcACewkBl\\noBlM+Wp0QGVACUvJKAsylgB2WgDVpaTaA1NloAqfZcWRPgBUSa8gnz+Vb24/P5a4a+fy4cfn8gY/\\nJ8sPL+T5On5JcPnOoOP5Plh5vnLt+T5PL8/ko5fOXKZb+c5cpUX9pS8iCNJaAP0g3BzUEwWKoWCB\\nIbAFZKADaAAIAUAkQDICoT5AVABUBQtU3ALVAAJtAWvIm+oB2YCwAQAAAtOVAQksFTCWApaIDSdp\\ng2UUtACwQFJTs6BbSwABLBUVJvcBFuIQBBAVBALJEkAQBUEBUDYF3ENwJpn5SWnyBz+U4cfnLr8n\\nH5g8/wA5cPm7/Nw+ajz/AJHn+b0/OMavP84B5/nq5zDt8o3c5hRzJamEEQ1WsN/D4ftIP0MCXNoA\\n2AVCxBU7AUnVAFAFDcAABAACywAsBQBKBQQDIAHYAAgCiGgBZ0gLaZ8G4AdiAFwJfALaCAogC4QA\\nLLEBUBQu4BLwCmENAXZLSUsGr8kzDOm62BMkzlABJ1UBNQAEUBEXYBJRqigZ3s6WgESWp0ScgksS\\n3LMxkHP5eXD5xq7/AC0c/lCjy/Nw+UPT8/i4/KAeX5xhw+cPV8o1cvl8QeX5fHDnPx8PT8vjMOfy\\n+MKPPMMzD0T8eEj8U/KcwDh8YmdHo/H+OcO/4v8AHuqiaer8f+LjOAf1gaDkomy7igCAqLaQALZs\\nAACzOBAFAEAQFAsCzoFEABZQEABRCvIAYyCAogKHQCAgBIJMiqgWAgCAGQOhAATY3Bf4l8koCpZa\\nWCpeSZQF7ELUUSwAAAN+DYAL8gAYNwRUsAAAAsBFtkEZlZZ3UY+THyblidAcflG7n8vi9Ew5zFg8\\nvy+Gzn8vx3mHsn42n6+RXh/6Eyf9res0936U1+oPDH+L8Y2v26fH8URiIev9U/XIjn8fh51bj4Rs\\n1HxaiEH2wGFRSxRF2CgK4FpKyIC9oKAoIAIB6AAAVAFXRBFRbLTcFLLEEURAUEFUwgCpcgAJ4BFw\\ngbAFkoACAAAbiABuJeQJC0sFQQF2QQATcBbEBVEBFLZAaLZFFstIALW2SZuAasZwA1/RLLoFsiUA\\nVLSUkCZ3ZnUlJUSWGkBiYZrDcpWQc4hY+P03EFAzUFNUoM1gn4tFAzEBID7B2DmoXkFCAUDYCRAN\\nwAVAWMyAAL5QEFJBANgEUUQCQQAEAABBSwskAEEAANwABDcACQLQANhAAkTUAQvAB7EugKBAVLAB\\nFmcoABYIEplRUsAVJkLwAG+EsFtWbLBoSywXctkmQWZS0tLuAOUnQQCWZalJUZ3FAQ2UkApN1AJQ\\nBJS1lgH2gMOaoqLyoBuAKFgBoCAWoIuQBFDcBFSwAOgDs6FEAAQOgQLAQVAA2NxUAEAOgQNgAsQA\\nLQFTYSwVBNgW0LQFSwAQABCwAAE2CwDQTcVZQFQEsQAkVRCSwUSQAQsFmUvKTJmhDZJklJBZnUZv\\nKgShyACALuIKAACgAzMZaT5A/9k=\\n\"\n" +
                        "}")
                .when()
                .put("clientProfile/updateSelfie")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.BOuserLogin, app.BOuserPass, username);
    }

    @Test(priority = 4)
    public void test_BOServices_v1_ticket_take() {
        for(int i = 0; i < 12; i++) {
            Response res = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");

            if(actualTypeName.equals("Selfie change")){
                break;
            }

            if(!actualTypeName.equals("Selfie change")){
                app.getBoRequestsHelper().boServices_v1_ticket_ticketId_postpone(cookie, ticketId, tomorrow);
            }

            Response res2 = app.getBoRequestsHelper().boServices_v1_ticket_take(cookie);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        assertEquals(actualTypeName, "Selfie change");
    }

    @Test(priority = 5)
    public void test_BOServices_v1_client_clientId_rejectSelfie() {
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .pathParam("clientId", clientId)
                .header("content-type", "application/json")
                .queryParam("ticketId", ticketId)
                .when()
                .post("/v1/client/{clientId}/rejectSelfie")
                .then().log().all()
                .statusCode(200);
    }
}