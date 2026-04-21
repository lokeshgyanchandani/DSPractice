package com.ds.companies.liveramp;

import java.util.stream.*;

public class TransactionStream {

	/*public Stream<PendingTransaction> reconcile(Stream<PendingTransaction> pending,
												Stream<Stream<ProcessedTransaction>> processed) {
		// Check for nulls
		if (processed == null) {
			if (pending == null)
				// return empty stream
			else
				return pending;
		}

		Stream<ProcessedTransaction> processedUnwrapped = processed.findFirst().get();
		pending.filter(p -> processedUnwrapped.anyMatch(c -> (Object)p.equals(c))
				&& (p.getId() instanceof Long && p.getId() != null && processedUnwrapped.getId() instanceof String &&
					(processedUnwrapped.getId() == null || processedUnwrapped.getId().equals("")) ||
					p.getId() == Long.parseLong(processedUnwrapped.getId())
				)
				&&
					(processedUnwrapped.getStatus().isPresent() || processedUnwrapped.getStatus().equalsIgnoreCase("DONE"))
		)
	}*/

}
