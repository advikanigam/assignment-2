/**
 * This class is generated by jOOQ
 */
package generated;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>public.system_sequence_a8e07312_6d74_4bd2_b3eb_856c1a53c25c</code>
	 */
	public static final Sequence<Long> SYSTEM_SEQUENCE_A8E07312_6D74_4BD2_B3EB_856C1A53C25C = new SequenceImpl<Long>("system_sequence_a8e07312_6d74_4bd2_b3eb_856c1a53c25c", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}