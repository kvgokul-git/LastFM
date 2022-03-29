package com.lastfm.app.stubs

import com.lastfm.app.data.api.dto.Wiki

@Suppress("MemberVisibilityCanBePrivate")
object WikiStub {

    private const val STUB_WIKI_PUBLISHED = "03 Mar 2010, 16:48"
    private const val STUB_WIKI_CONTENT =
        "Believe is the twenty-third studio album by American  singer-actress Cher, released on November 10, 1998 by Warner Bros. Records. The RIAA certified it Quadruple Platinum on December 23, 1999, recognizing four million shipments in the United States; Worldwide, the album has sold more than 20 million copies, making it the biggest-selling album of her career. In 1999 the album received three Grammy Awards nominations including \\\"Record of the Year\\\", \\\"Best Pop Album\\\" and winning \\\"Best Dance Recording\\\" for the single \\\"Believe\\\".\\n\\nIt was released by Warner Bros. Records at the end of 1998. The album was executive produced by Rob Dickens. Upon its debut, critical reception was generally positive. Believe became Cher's most commercially-successful release, reached number one and Top 10 all over the world. In the United States, the album was released on November 10, 1998, and reached number four on the Billboard 200 chart, where it was certified four times platinum.\\n\\nThe album featured a change in Cher's music; in addition, Believe presented a vocally stronger Cher and a massive use of vocoder and Auto-Tune. In 1999, the album received 3 Grammy Awards nominations for \\\"Record of the Year\\\", \\\"Best Pop Album\\\" and winning \\\"Best Dance Recording\\\". Throughout 1999 and into 2000 Cher was nominated and winning many awards for the album including a Billboard Music Award for \\\"Female Vocalist of the Year\\\", Lifelong Contribution Awards and a Star on the Walk of Fame shared with former Sonny Bono. The boost in Cher's popularity led to a very successful Do You Believe? Tour.\\n\\nThe album was dedicated to Sonny Bono, Cher's former husband who died earlier that year from a skiing accident.\\n\\nCher also recorded a cover version of \\\"Love Is in the Air\\\" during early sessions for this album. Although never officially released, the song has leaked on file sharing networks.\\n\\nSingles\\n\\n\\n\\\"Believe\\\"\\n\\\"Strong Enough\\\"\\n\\\"All or Nothing\\\"\\n\\\"Dov'è L'Amore\\\" <a href=\\\"https://www.last.fm/music/Cher/Believe\\\">Read more on Last.fm</a>. User-contributed text is available under the Creative Commons By-SA License; additional terms may apply."

    fun new(
        published: String = STUB_WIKI_PUBLISHED,
        content: String = STUB_WIKI_CONTENT
    ) = Wiki(
        published = published,
        content = content
    )
}